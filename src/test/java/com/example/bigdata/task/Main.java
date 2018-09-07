package com.example.bigdata.task;
 
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
 
public class Main {
 
    /*static class MyTaskTest extends RecursiveTask<Integer> {
        final int n;
        MyTaskTest(int n) {
            this.n = n;
        }
        @Override
        protected Integer compute() {
            if (n <= 1) return n;
            MyTaskTest f1 = new MyTaskTest(n - 1);
            f1.fork();
            MyTaskTest f2 = new MyTaskTest(n - 2);
            return f2.compute() + f1.join();
        }
    }*/
 
    /*class SortTask extends RecursiveAction {
        static final int THRESHOLD = 2;
        final long[] array;
        final int lo;
        final int hi;
        SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }
        protected void compute() {
            if (hi - lo < THRESHOLD)
                sequentiallySort(array, lo, hi);
            else {
                int mid = (lo + hi) >>> 1;
                invokeAll(new SortTask(array, lo, mid),
                        new SortTask(array, mid, hi));
                merge(array, lo, hi);
            }
        }
    }*/
 
    private static int[] genArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(500);
        }
        return array;
    }
 
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 下面以一个有返回值的大任务为例，介绍一下RecursiveTask的用法。
         大任务是：计算随机的100个数字的和。
         小任务是：每次只能20个数值的和。
         */
        int[] array = genArray();
 
//        System.out.println(Arrays.toString(array));
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        System.out.println("目标和：" + total);
 
        // 1. 创建任务
        SumTask sumTask = new SumTask(array, 0, array.length - 1);
 
        // 2. 创建线程池
        // 设置并行计算的个数
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
        ForkJoinPool forkJoinPool = new ForkJoinPool(processors * 2);
 
        // 3. 提交任务到线程池
        forkJoinPool.submit(sumTask);
//        forkJoinPool.shutdown();
 
        long begin = System.currentTimeMillis();
        // 4. 获取结果
        Integer result = sumTask.get();// wait for
        long end = System.currentTimeMillis();
        System.out.println(String.format("结果 %s ，耗时 %sms", result, end - begin));
 
        if (result == total) {
            System.out.println("测试成功");
        } else {
            System.out.println("fork join 使用失败！！！！");
        }
    }
}
