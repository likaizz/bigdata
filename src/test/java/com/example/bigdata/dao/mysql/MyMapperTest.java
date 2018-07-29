package com.example.bigdata.dao.mysql;

import com.example.bigdata.AbstractTest;
import com.example.bigdata.dao.mysql.MyMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyMapperTest extends AbstractTest {
    @Autowired
    private MyMapper myMapper;
    @Test
    public void testInsertOne(){
        Map one = new HashMap<>();
        one.put("name", UUID.randomUUID().toString());
        one.put("time", new Date());
        int count=myMapper.insertOne(one);
        System.out.println(count);
    }
}
