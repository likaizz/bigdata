package com.example.bigdata.controller.impl;

import com.example.bigdata.controller.IMyController;
import com.example.bigdata.domain.neo4j.Emp;
import com.example.bigdata.repository.neo4j.NeoEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MyController implements IMyController {
    @Autowired
    private NeoEmpRepository neoEmpRepository;
    @Override
    public Date getTime() {
        return new Date();
    }

    @Override
    public Emp create() {
        Emp e=new Emp();
        e.setEname(UUID.randomUUID().toString());
        return neoEmpRepository.save(e);
    }
}
