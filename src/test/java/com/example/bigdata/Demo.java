package com.example.bigdata;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String str="abcdefghijklmnopqrstuvwxyza";
        List<String> stringList=new ArrayList<>();
        int length=str.length();
        int times= (int) Math.ceil(length/2.0);
        for (int j = 0; j <times ; j++) {
            int start=j*2;
            int end=start+2;
            if(j==times-1)end=length;
            stringList.add(str.substring(start,end));
        }
        System.out.println(stringList);
    }
}
