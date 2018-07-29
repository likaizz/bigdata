package com.example.bigdata.dao.oracle;

import com.example.bigdata.AbstractTest;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyMapperTest extends AbstractTest {
    @Autowired
    private OraMyMapper myMapper;
    @Test
    public void testInsertOne(){
        Map one = new HashMap<>();
        one.put("id",new ObjectId().toString());
        one.put("name", UUID.randomUUID().toString());
        one.put("age",27);
        one.put("createTime", new Date());
        int count=myMapper.insertOne(one);
        System.out.println(count);
    }
}
