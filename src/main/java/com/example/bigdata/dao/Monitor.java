package com.example.bigdata.dao;

public interface Monitor {
/*    default ThreadLocal<String>recordId=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return null;
        }
    };*/
   /* public default String getRecordId(){
        String id=recordId.get();
        System.out.println(Thread.currentThread().getName()+":getRecordId("+id+")");
        return id;
    }

    public default void setRecordId(String id){
        System.out.println(Thread.currentThread().getName()+":setRecordId("+id+")");
         recordId.set(id);
    }*/

   public Object monitor(String logId,Object...args)throws Throwable;
}
