package com.example.bigdata.dao.oracle;

import com.example.bigdata.common.type.String2ClobHandler;
import com.example.bigdata.domain.TestDO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.CaseInsensitiveMap;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OraMyMapper /*extends Monitor*/{

    static class Provider {

    }


    @Insert("insert into my values(#{id},#{name},#{age},#{createTime})")
    public int insertOne(Map map);

    @Results(@Result(column = "remark", property = "remark",typeHandler =com.example.bigdata.common.type.String2ClobHandler.class ))
    @Select("<script>select <foreach collection='strs' item='one' open='(' separator='||' close=')'>to_clob(#{one})</foreach>  clob from dual</script>")
    public String getClob(@Param("strs") String str);

//    @Results(@Result(column = "remark", property = "remark",javaType = char[].class,jdbcType = JdbcType.CLOB))
    @Select("select   id,remark  from test where  rownum<2")
    public TestDO getOne();

//    @ResultType(LinkedCaseInsensitiveMap.class)
    @Select("select   id,remark  from test where remark is null")//where  rownum<2
    public List<LinkedCaseInsensitiveMap> getOneMap();//<Map<String,Object>/*CaseInsensitive*//*LinkedCaseInsensitiveMap*/>

    @Insert("insert into test  select #{id} as id,#{remark} as remark from dual  ")
    public int  insertOneMap(Map<String,Object>map);


    @Results(@Result(property = "remark",javaType = String.class,jdbcType = JdbcType.CLOB,typeHandler = String2ClobHandler.class))
//    @Insert("with tmp as (select #{id} as id,to_lob(#{remark}) as remark from dual  ) insert into test_1 select id,remark from tmp ")///,javaType=String,jdbcType=CLOB,typeHandler=com.example.bigdata.common.type.String2ClobHandler
    @Insert(" merge into test t1 using ( select #{id} as id,to_blob(#{remark,javaType=String,jdbcType=CLOB,typeHandler=com.example.bigdata.common.type.String2ClobHandler}) as remark from dual) as t2 on(t1.id=t2.id)" +
            " when not matched then insert values(t2.id,t2.remark)" +
            "  ")///
    public int  insertOneTestDO(TestDO testDO);


    @Results(@Result(property = "strs",typeHandler = String2ClobHandler.class))
    @Insert("insert into test (remark) <script>select <foreach collection='strs' item='one' open='(' separator='||' close=')'>to_clob(#{one})</foreach>  remark from dual</script>")
//    @InsertProvider(type=Provider.class,method = "")
//    @Insert("<script>select  to_clob(#{strs})  clob from dual</script>")//,javaType=String,jdbcType=CLOB,typeHandler=com.example.bigdata.common.type.String2ClobHandler
    public void getClobByString(@Param("strs") String str);

//    @Select("<script><foreach collection='str.getBytes()' item='one' open='(' separator='union' close=')'>select #{one} from dual </foreach> </script>")
    @Select("<script><foreach collection='str.getBytes()' item='one'  separator='||' >select #{one} from dual </foreach> </script>")
    public byte[] testString(@Param("str") String str);

    public static byte[] getBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("utf-8");
    }

//    @Select({"select 1 id from dual","select 2 id from dual","select 3 id from dual"})
//    public List<Map<String,Object>> tesdt();


}
