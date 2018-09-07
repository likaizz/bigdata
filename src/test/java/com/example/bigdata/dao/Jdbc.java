package com.example.bigdata.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:my", "SCOTT", "scott");
        connection.setAutoCommit(false);
        System.out.println(connection);
        String param = "李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz";
        StringBuilder sb = new StringBuilder("select '" + UUID.randomUUID().toString() + "' id,");
        List<String> stringList = new ArrayList<>();
        int length = param.length();
        int times = (int) Math.ceil(length / 1000.0);
        for (int j = 0; j < times; j++) {
            sb.append(" to_clob(?)");
            int start = j * 1000;
            int end = start + 1000;
            if (j == times - 1) {
                end = length;
                sb.append(" remark from dual");
            } else sb.append("||");
            stringList.add(param.substring(start, end));
        }
        System.out.println(sb);

        String sql = "merge into test t1 using ( " + sb + " )  t2  on (t1.id=t2.id) when not matched then insert values(t2.id,t2.remark)";
        System.out.println(sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 1; i <= times; i++) {
            preparedStatement.setObject(i, stringList.get(i - 1));
        }

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            for (int i = 1; i <= count; i++) {
                System.out.println(rs.getObject(i));
            }
            connection.commit();

//            System.out.println(rs.get(1));
        }


    }

//    Exception in thread "main" java.sql.SQLException: ORA-01461: 仅能绑定要插入 LONG 列的 LONG 值
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("oracle.jdbc.OracleDriver");
//        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:my", "SCOTT", "scott");
//        System.out.println(connection);
//        String param = "李凯追踪你一胡按时zzzzzzzzvjhkvhjvhjvjhvhjvhvhjvhjvjhvhjvjhvhjvhjvjhvhjvhjvhjv李凯追胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯追踪你一胡按时zzz李凯zzlikaizzzzz追踪你一胡按时zzz李凯追踪你一胡按时zzzzz";
//        StringBuilder sb = new StringBuilder("select '" + UUID.randomUUID().toString() + "' id,to_clob(?) remark from dual");
//
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into test " + sb);
//        preparedStatement.setObject(1, param);
//
//        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()) {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int count = metaData.getColumnCount();
//            for (int i = 1; i <= count; i++) {
//                System.out.println(rs.getObject(i));
//            }
//        }
//
//    }
}
