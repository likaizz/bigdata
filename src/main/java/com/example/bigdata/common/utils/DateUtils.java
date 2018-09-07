package com.example.bigdata.common.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
    public static List<Date> spiltDate(Date start,Date end){
        List<Date>list=new ArrayList<>();
        list.add(start);
        Date tmp=oneDayAfter(start);
        if(tmp.after(end)||tmp.equals(end)){
            list.add(end);
            return list;
        }
        list.add(tmp);
        while((tmp=oneDayAfter(tmp)).before(end)){
            list.add(tmp);
        }
        list.add(end);
        return list;



    }

    public static Date oneDayAfter(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+1);
        Date result=calendar.getTime();
        System.out.println(result);
        return result;
    }
}
