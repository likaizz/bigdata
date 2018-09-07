package com.example.bigdata.dao;

import com.example.bigdata.common.utils.MyStringUtils;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

public class JDBC2 {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("oracle.jdbc.OracleDriver");
//        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:my", "SCOTT", "scott");
////        connection.setAutoCommit(false);
//        StringBuilder sb = new StringBuilder();
//        sb.append("begin ");
//        for (int i = 0; i <5000; i++) {
//            sb.append(" insert into test values (?,?);");
//        }
//        sb.append(" end;");
//        System.out.println(sb);
//        PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
//        for (int i = 0; i <5000 ; i++) {
//            preparedStatement.setObject(i*2+1, UUID.randomUUID().toString());
//            preparedStatement.setObject(i*2+2, UUID.randomUUID().toString());
//        }
//
//        long s=System.currentTimeMillis();
//        preparedStatement.execute();
//        System.out.println(System.currentTimeMillis()-s);
//
//    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:my", "SCOTT", "scott");
//        connection.setAutoCommit(false);
        StringBuilder sb = new StringBuilder();
/*        sb.append("begin ");
        for (int i = 0; i <5000; i++) {
            sb.append(" insert into test values (?,?);");
        }
        sb.append(" end;");
//        System.out.println(sb);*///test_in_list
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into test values (?,?)");
//        PreparedStatement preparedStatement = connection.prepareStatement("update test set remark=? where id=?");
        PreparedStatement preparedStatement = connection.prepareStatement("merge into test t1 using ( select ? id,test_in_list(?) remark from dual )  t2  on (t1.id=t2.id) when  matched then update set t1.remark=t2.remark when not matched then insert values(t2.id,t2.remark)");
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into test  select ? id,test_in_list(?) remark from dual ");
        String remark="hello李凯追踪你一胡按时zzzzzz李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz李凯追踪你一胡按时zzzzzz李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz";
        for (int i = 0; i <5000 ; i++) {
            preparedStatement.setObject(1, UUID.randomUUID().toString());
//            preparedStatement.setObject(2, UUID.randomUUID().toString());
            String parameter=i+remark;

            ArrayDescriptor tabDesc = ArrayDescriptor.createDescriptor("str_arr".toUpperCase(), connection);
            ARRAY vArray = new ARRAY(tabDesc, connection, MyStringUtils.subStrings(parameter).toArray());
            preparedStatement.setArray(2,vArray);
//            StringReader reader = new StringReader(parameter);
//            preparedStatement.setCharacterStream(2, reader, parameter.length());
            preparedStatement.addBatch();
        }

        long s=System.currentTimeMillis();
        int[]result=preparedStatement.executeBatch();
        System.out.println(System.currentTimeMillis()-s);
        System.out.println(Arrays.toString(result));

    }
}
