package com.example.bigdata.domain;

import oracle.sql.CLOB;

import java.sql.Clob;
import java.sql.SQLException;

public class OraTestDO {
    private String id;
    private String remark;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
