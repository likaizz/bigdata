package com.example.bigdata.task;

import com.example.bigdata.common.utils.DateUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTask extends RecursiveTask<List<Record>> {
    private Date paramStart;
    private Date paramEnd;
    private List<Date> list;
//    private AtomicInteger count=new AtomicInteger(0);

    public MyTask(Date paramStart, Date paramEnd) {
        this.paramStart = paramStart;
        this.paramEnd = paramEnd;
        list = DateUtils.spiltDate(paramStart, paramEnd);
    }

    @Override
    protected List<Record> compute() {
        List<Record> result = new ArrayList<>();
        //String status, int total, String msg, Date start, Date end, Date paramStart, Date paramEnd

        if (list.size() == 2) {
            Record record = null;
            try {
                Thread.sleep(200);
                record = new Record("1", RandomUtils.nextInt(), "ok", new Date(), null, paramStart, paramEnd);
                System.out.println(Thread.currentThread().getName()+"|"+record);
//                count.addAndGet(x);
                if(Math.random()<0.7)throw new RuntimeException("exception");

            } catch (Exception e) {
                record.setStatus("0");
                record.setTotal(0);
                record.setMsg(e.getMessage());
            } finally {
                record.setEnd(new Date());
                result.add(record);
            }
        } else {
            Date middle = list.get(list.size()/2);

            MyTask subTask1 = new MyTask(paramStart, middle);
            MyTask subTask2 = new MyTask(middle, paramEnd);

            invokeAll(subTask1,subTask2);

            result.addAll(subTask1.join());
            result.addAll(subTask2.join());
            System.out.println("");

//            subTask1.fork();
//            subTask2.fork();

            /*for (int i = 1; i < list.size(); i++) {
                Date subS = list.get(i - 1);
                Date subE = list.get(i);
                MyTask subTask = new MyTask(subS, subE);
                subTask.fork();
                result.addAll(subTask.join());
            }*/
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Date>list = DateUtils.spiltDate(new Date(1534723200000l), new Date());
//        System.out.println(list);


        MyTask myTask=new MyTask(new Date(1534723200000l),new Date());
        int cup=Runtime.getRuntime().availableProcessors();
        System.out.println(cup);
        ForkJoinPool pool=new ForkJoinPool(cup);
        ForkJoinTask<List<Record>> result=pool.submit(myTask);
        long start=System.currentTimeMillis();
        List<Record>list=result.get();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        for(Record x:list){
            System.out.println(x);
        }
    }
}
