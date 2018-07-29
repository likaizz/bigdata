package com.example.bigdata.service;

import com.example.bigdata.dao.mysql.MyMapper;
import com.example.bigdata.dao.oracle.OraMyMapper;
import org.bson.types.ObjectId;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MultiTransactionService {
    @Autowired
    private OraMyMapper oraMyMapper;
    @Autowired
    private MyMapper myMapper;

    @Autowired
    private Session session;
    @Autowired
    private ChainedTransactionManager multiTXManager;

    public void testTX() {
        System.out.println(multiTXManager);
    }

    @Transactional(transactionManager = "multiTransactionManager")
    public void multiTX() {
        Map one = new HashMap<>();
        one.put("name", UUID.randomUUID().toString());
        one.put("time", new Date());

        int count = myMapper.insertOne(one);

        one.clear();
        one.put("id", new ObjectId().toString());
        one.put("name", UUID.randomUUID().toString());
        one.put("age", 27);
        one.put("createTime", new Date());
        oraMyMapper.insertOne(one);

        String insert = "create (x:neo) set x={one}";
        Map params = new HashMap(1);

        params.put("one", one);
        Result result = session.query(insert, params);

//        throw new RuntimeException();
    }

}
