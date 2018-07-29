package com.example.bigdata.dao.neo4j;

import com.example.bigdata.AbstractTest;
import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NeoTest extends AbstractTest {
    @Autowired
    private Neo4jTransactionManager neo4jTransactionManager;
    @Test
    public void testTX(){
        System.out.println(neo4jTransactionManager);
    }
    @Test
    @Transactional
    public void testTransaction() {
        String insert = "create (x:neo) set x={one}";
        Map params = new HashMap(1);
        Map one = new HashMap<>();
        one.put("name", "likai");
        one.put("age", 27);
        one.put("date", new Date());
        params.put("one", one);
        Result result = neoSession.query(insert, params);
        Iterator it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //不加@Transactional注解,大方法后面异常,不会回退
        throw new RuntimeException();
    }
}
