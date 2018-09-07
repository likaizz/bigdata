package com.example.bigdata.common.utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MyStringUtils {
    public static List<String> subStrings(String str){
        if(StringUtils.isEmpty(str))return null;
        List<String>result=new ArrayList<>();
        int length = str.length();
        int times = (int) Math.ceil(length / 1000.0);
        for (int j = 0; j < times; j++) {
            int start = j * 1000;
            int end = start + 1000;
            if (j == times - 1) {
                end = length;
            }
            result.add(str.substring(start, end));
        }
        return result;
    }
}
