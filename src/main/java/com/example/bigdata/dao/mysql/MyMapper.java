package com.example.bigdata.dao.mysql;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface MyMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into my values(#{id},#{name},#{time})")
    public int insertOne(Map one);
}
