package com.example.bigdata.dao;

import com.example.bigdata.AbstractTest;
import com.example.bigdata.dao.mysql.MyMapper;
import com.example.bigdata.dao.oracle.OraMyMapper;
import com.example.bigdata.service.MultiTransactionService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MultiTransactionTest extends AbstractTest {
    @Autowired
    private OraMyMapper oraMyMapper;
    @Autowired
    private MyMapper myMapper;
    @Autowired
    private ChainedTransactionManager multiTXManager;

    @Test
    public void testTX(){
        System.out.println(multiTXManager);
    }

    @Test
    @Transactional(transactionManager = "multiTransactionManager")
    public void multiTX(){
        Map one = new HashMap<>();
        one.put("name", UUID.randomUUID().toString());
        one.put("time", new Date());

        int count=myMapper.insertOne(one);

        one.clear();
        one.put("id",new ObjectId().toString());
        one.put("name", UUID.randomUUID().toString());
        one.put("age",27);
        one.put("createTime", new Date());
        oraMyMapper.insertOne(one);

        String insert = "create (x:neo) set x={one}";
        Map params = new HashMap(1);

        params.put("one", one);
        Result result = neoSession.query(insert, params);
//        throw new RuntimeException();
    }

    @Autowired
    private MultiTransactionService service;

    @Test
    public void testService(){
        service.multiTX();
    }

}
