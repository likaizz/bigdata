package com.example.bigdata.dao.oracle;

import com.example.bigdata.AbstractTest;

import java.io.UnsupportedEncodingException;
import java.sql.Clob;

import com.example.bigdata.domain.OraTestDO;
import com.example.bigdata.domain.TestDO;
import org.apache.ibatis.annotations.Mapper;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.*;

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

    @Test
    public void testClob(){
        String str="select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual\n" +
                "select sysdate from dual";
//        String clob=myMapper.getClob(str.split("from"));
//        System.out.println(clob);
    }

    @Test
    public  void testGet(){
        TestDO test=myMapper.getOne();
        System.out.println(test);

//[{ID=0010097d-0e9b-46f8-9069-3009979bfd84, REMARK=null}, {ID=00037add-262e-4f0f-8129-6fbd3004c45d, REMARK=null}, {ID=000eca89-6b59-4274-bcb0-6fd81a1eb067, REMARK=null}, {ID=00096052-0c2c-4c31-b471-778506caa379, REMARK=null}, {ID=000f0138-aeba-4c35-8907-91654f7e0adb, REMARK=null}, {ID=000f46b3-abe4-48b7-83bd-124b40fd73e0, REMARK=null}, {ID=0006cb4e-1946-4f0d-9a41-8499ca712e86, REMARK=null}, {ID=0001ebba-c674-4559-b4af-b9145b97fc48, REMARK=null}, {ID=000e5c5e-e024-492b-bef9-90da0e3ec08a, REMARK=null}]
        List<LinkedCaseInsensitiveMap > list=myMapper.getOneMap();
        System.out.println(list);
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(0).get("id"));
//        Object remarkObj=map.get("REMARK");
//        if(remarkObj instanceof Clob){
//            System.out.println("Clob cast");
//            System.out.println((Clob)remarkObj);
//
//        }
//        System.out.println(remarkObj);
//        System.out.println(remarkObj.getClass());
//
//        System.out.println();
    }

    @Test
    public  void testInsert(){
        TestDO test=new TestDO();
        test.setId(UUID.randomUUID().toString());
        test.setRemark("李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz");
        myMapper.insertOneTestDO(test);
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String str="中国likaizz";
        byte[]bs=str.getBytes("utf-8");
        System.out.println(Arrays.toString(bs));
    }

    @Test
    public void testArray(){
        byte[]bs=myMapper.testString("中国likaizz");
        System.out.println(Arrays.toString(bs));
    }

    @Test
    public void testgetClob(){
//        System.out.println(myMapper.getClob("李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz"));
        myMapper.getClobByString("likaizz李凯");
        System.out.println();
    }

    @Autowired
    private OraDemoMapper oraTestMapper;

    @Test
    public void testGetOne(){
//        System.out.println(oraTestMapper.getOne());
        //
        String remark="hello李凯追踪你一胡按时zzzzzz李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz李凯追踪你一胡按时zzzzzz李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz";
        TestDO testDO=new TestDO(UUID.randomUUID().toString(),"likaizzremark");
        testDO.setRemark(remark);
        testDO.setId("0de32566-489b-45bc-acaf-e9ba6cb4a972");
//        oraTestMapper.insertOneTestDO(testDO);
//        List<String> stringList = new ArrayList<>();
//        int length = remark.length();
//        int times = (int) Math.ceil(length / 1000.0);
//        for (int j = 0; j < times; j++) {
//            int start = j * 1000;
//            int end = start + 1000;
//            if (j == times - 1) {
//                end = length;
//            }
//            stringList.add(remark.substring(start, end));
//        }
//        System.out.println(oraTestMapper.test(testDO,stringList));
        System.out.println(oraTestMapper.updateOne(testDO));
//        List list=new ArrayList();
//        String[]strings=new String[list.size()];
//        System.out.println(oraTestMapper.test(testDO,strings);
    }

    @Test
    public void testMergeMany(){
        List<TestDO>list=new ArrayList<>();
        String remark="hello李凯追踪你一胡按时";
        for (int i = 0; i < 11; i++) {
            TestDO testDO=new TestDO(UUID.randomUUID().toString(),null);
            testDO.setRemark(i+remark);
            list.add(testDO);
        }
        System.out.println(oraTestMapper.mergeMany(list));
    }


}
