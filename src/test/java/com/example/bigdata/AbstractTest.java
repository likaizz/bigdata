package com.example.bigdata;

import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BigdataApplication.class)
public abstract class AbstractTest {
    @Autowired
    protected MongoTemplate mongoTemplate;
    @Autowired
    protected Session neoSession;
}
