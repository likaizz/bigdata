package com.example.bigdata.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Record {
    private String id;
    private Date create_time;
    private Date modify_time;
    private String batch_no;
    private Character status;//'0'表示初始化,'1'表示正在执行,'2'表示执行成功,'3'表示执行异常
    private String msg;
}
