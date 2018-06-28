package com.example.bigdata.controller;

import com.example.bigdata.domain.neo4j.Emp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("my")
public interface IMyController {
    @GetMapping("time")
    public Date getTime();

    @GetMapping("create")
    public Emp create();
}
