//package com.example.bigdata.common.type;
//
//import oracle.sql.CLOB;
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//
//import java.sql.*;
//
//public class CLOBTypeHandler extends BaseTypeHandler<CLOB> {
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, CLOB parameter, JdbcType jdbcType) throws SQLException {
//        System.out.println("CLOBTypeHandler.setNonNullParameter");
//    }
//
//    @Override
//    public CLOB getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        System.out.println("CLOBTypeHandler.getNullableResult(ResultSet rs, String columnName)");
//        Clob clob = rs.getClob(columnName);
//        return clob;
//    }
//
//    @Override
//    public CLOB getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        System.out.println("CLOBTypeHandler.getNullableResult(ResultSet rs, int columnIndex)");
//        return null;
//    }
//
//    @Override
//    public CLOB getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        System.out.println("CLOBTypeHandler.getNullableResult(CallableStatement cs, int columnIndex)");
//        return null;
//    }
//}
