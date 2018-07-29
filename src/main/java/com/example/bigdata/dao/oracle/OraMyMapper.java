package com.example.bigdata.dao.oracle;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface OraMyMapper {
    @Insert("insert into my values(#{id},#{name},#{age},#{createTime})")
    public int insertOne(Map map);
}
