package com.example.bigdata.common.type;

import org.apache.ibatis.type.ClobTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyClobTypeHandler extends ClobTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setClob(i,new StringReader(parameter));
    }
}
