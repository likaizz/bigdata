package com.example.bigdata.dao.mongo;

import com.example.bigdata.AbstractTest;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MongoTest extends AbstractTest{
    @Test
    @Transactional//事务注解对mongo无效
    public void testTransaction(){
        MongoDatabase db=mongoTemplate.getDb();
        WriteConcern writeConcern=db.getWriteConcern();


        Map map=new HashMap<>();
        map.put("name","likai");
        map.put("age",27);
        map.put("date",new Date());
        mongoTemplate.insert(map,"map");

        throw new RuntimeException();
    }
}
