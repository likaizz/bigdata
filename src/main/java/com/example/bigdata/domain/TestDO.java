package com.example.bigdata.domain;

import com.alibaba.druid.util.StringUtils;
import com.example.bigdata.common.type.String2ClobHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.CLOB;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.sql.Clob;
import java.util.List;

@Data
public class TestDO {

    private String id;

    private String remark;

    private List<String> remark_substrs;

    public TestDO() {
    }

    public TestDO(String id, String remark) {
        this.id = id;
        this.remark = remark;
    }

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
//        this.remark_substrs= StringUtils.
    }

   /* public char[] getRemark() {
        return remark;
    }

    public void setRemark(char[] remark) {
        this.remark = remark;
    }*/

    public List<String> getRemark_substrs() {
        return remark_substrs;
    }

    public void setRemark_substrs(List<String> remark_substrs) {
        this.remark_substrs = remark_substrs;
    }

    @Override
    public String toString() {
        return "TestDO{" +
                "id='" + id + '\'' +
                ", remark=" + remark +
                '}';
    }
}
