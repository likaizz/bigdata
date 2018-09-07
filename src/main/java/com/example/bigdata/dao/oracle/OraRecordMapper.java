package com.example.bigdata.dao.oracle;

import com.example.bigdata.domain.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OraRecordMapper {
    @Insert("insert into record values(#{id},sysdate,sysdate,#{batch_no},#{status},null)")
    public int insertOne(Record record);
    @Update("update record set modify_time=sysdate,status=#{status},msg=#{msg}")
    public int updateOne(Record record);
}
