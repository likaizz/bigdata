package com.example.bigdata.task;

import java.util.Date;

public class Record {
    private String status;
    private int total;
    private String msg;
    private Date start;
    private Date end;
    private Date paramStart;
    private Date paramEnd;

    public Record() {
    }

    public Record(String status, int total, String msg, Date start, Date end, Date paramStart, Date paramEnd) {
        this.status = status;
        this.total = total;
        this.msg = msg;
        this.start = start;
        this.end = end;
        this.paramStart = paramStart;
        this.paramEnd = paramEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getParamStart() {
        return paramStart;
    }

    public void setParamStart(Date paramStart) {
        this.paramStart = paramStart;
    }

    public Date getParamEnd() {
        return paramEnd;
    }

    public void setParamEnd(Date paramEnd) {
        this.paramEnd = paramEnd;
    }

    @Override
    public String toString() {
        return "Record{" +
                "status='" + status + '\'' +
                ", total=" + total +
                ", msg='" + msg + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", paramStart=" + paramStart +
                ", paramEnd=" + paramEnd +
                '}';
    }
}
