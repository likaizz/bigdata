package com.example.bigdata.common.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@MappedJdbcTypes(JdbcType.CLOB)
//@MappedTypes(String.class)
public class String2ClobHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("myTypeHandler");
//        StringReader reader = new StringReader(parameter);
//        preparedStatement.setCharacterStream(i, reader, parameter.length());
        List<String> stringList=new ArrayList<>();
        int length=parameter.length();
        int times= (int) Math.ceil(length/1000.0);
        for (int j = 0; j <times ; j++) {
            int start=j*1000;
            int end=start+1000;
            if(j==times-1)end=length;
            stringList.add(parameter.substring(start,end));
        }
        preparedStatement.setObject(i,stringList);
//        try {
//            byte[]bytes=parameter.getBytes("utf-8");
//            preparedStatement.setBinaryStream(i,new ByteArrayInputStream(bytes),bytes.length);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("myTypeHandler.getNullableResult(ResultSet resultSet, String s)");
        String value = "";
        Clob clob = resultSet.getClob(s);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1, size);
        }
        return value;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("myTypeHandler.getNullableResult(ResultSet resultSet, int i)");
        String value = "";
        Clob clob = resultSet.getClob(i);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1, size);
        }
        return value;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("myTypeHandler.getNullableResult(CallableStatement callableStatement, int i)");
        String value = "";
        Clob clob = callableStatement.getClob(i);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1, size);
        }
        return value;
    }
}
