package com.example.bigdata.dao.oracle;

import com.example.bigdata.common.type.String2ClobHandler;
import com.example.bigdata.common.utils.MyStringUtils;
import com.example.bigdata.domain.OraTestDO;
import com.example.bigdata.domain.TestDO;
import com.sun.scenario.effect.Merge;
import oracle.sql.CLOB;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;

@Mapper
@Repository
public interface OraDemoMapper {
    static class Provider {
        public String getMergeSql(Map<String, Object> params) {
            System.out.println(params);
            String remark = (String) params.get("remark");
            String merge = "merge into test t1 using ( select #{id} as id,to_clob(#{remark}) as remark from dual)  t2 on(t1.id=t2.id)\" +\n" +
                    " when not matched then insert values(t2.id,t2.remark)";
            return merge;
        }

        public String test(/*TestDO testDO*/Map<String, Object> params) {
//            System.out.println(testDO.getRemark());
//            SQL sql = new SQL();
            TestDO testDO = (TestDO) params.get("testDO");
            String param = testDO.getRemark();
            StringBuilder sb = new StringBuilder("select #{testDO.id} id,");
            List<String> stringList = new ArrayList<>();
            params.put("subStrs", stringList);
            int length = param.length();
            int times = (int) Math.ceil(length / 1000.0);
            for (int j = 0; j < times; j++) {
                sb.append(" to_clob(#{subStrs[" + j + "]})");
                int start = j * 1000;
                int end = start + 1000;
                if (j == times - 1) {
                    end = length;
                    sb.append(" remark from dual");
                } else sb.append("||");
                stringList.add(param.substring(start, end));
            }
            System.out.println(sb);

            String sql = "merge into test t1 using ( " + sb + " )  t2  on (t1.id=t2.id) when not matched then insert values(t2.id,t2.remark)";
            System.out.println(sql);
            return sql;
        }

        public String mergeMany(/*Map<String,Object>params*/@Param("list") List<TestDO> list) {
//            List<TestDO> list= (List<TestDO>) params.get("list");
            System.out.println(list.size());
            StringBuilder dual = new StringBuilder();
            StringBuilder sql=new StringBuilder("begin ");
            for (int i = 0; i < list.size(); i++) {
                TestDO testDO = list.get(i);
//                StringBuilder sb = new StringBuilder("select #{list["+i+"].id} id,'' remark from dual union ");
                StringBuilder sb = new StringBuilder("select #{list[" + i + "].id} id,");//get("+i+")
                String remark = testDO.getRemark();
                List<String> remark_substrs = MyStringUtils.subStrings(remark);
                testDO.setRemark_substrs(remark_substrs);
                if (CollectionUtils.isEmpty(remark_substrs)) {
                    sb.append("'' remark from dual ");
                } else {
                    int size = remark_substrs.size();
                    for (int j = 0; j < size; j++) {
                        sb.append(" to_clob(#{list[" + i + "].remark_substrs[" + j + "]})");//to_clob
                        if (j == size - 1) {
                            sb.append(" remark from dual ");
                        } else sb.append("||");
                    }
                }
                System.out.println(sb);
                sql.append("merge into test t1 using ( " + sb + " )  t2  on (t1.id=t2.id) when matched then update set t1.remark=t2.remark  when not matched then insert values(t2.id,t2.remark);");
                if(i==list.size()-1)sql.append(" end; ");
            }
            System.out.println(dual);
//            String sql="select count(1) from ("+dual+")";
//            return dual.toString();
            return sql.toString();
        }

    }


    //@Result注解只对查询结果有效
//    @Results(@Result(property = "remark",column = "remark",javaType = String.class,jdbcType = JdbcType.CLOB,typeHandler = String2ClobHandler.class))
//    @Insert("with tmp as (select #{id} as id,to_lob(#{remark}) as remark from dual  ) insert into test_1 select id,remark from tmp ")///,javaType=String,jdbcType=CLOB,typeHandler=com.example.bigdata.common.type.String2ClobHandler
    @Insert(" merge into test t1 using ( select #{id} as id,to_clob(#{remark}) as remark from dual)  t2 on(t1.id=t2.id)" +
            " when not matched then insert values(t2.id,t2.remark)")
    public int insertOneTestDO(TestDO testDO);

    //(select语句下指定typeHandler将生效)不指定typeHandler,将使用默认的typeHandler
    @Results(@Result(property = "remark", column = "remark"/*,typeHandler = String2ClobHandler.class*/))
    @Select("select * from test where rownum<2")
    public OraTestDO getOne();


    //    @InsertProvider(type = Provider.class, method = "getMergeSql")
//    @Insert(" merge into test t1 using ( select #{id} as id,to_clob(#{remark}) as remark from dual)  t2 on(t1.id=t2.id)" +
//            " when not matched then insert values(t2.id,t2.remark)")
    @Insert("insert into test values(#{id},#{remark})")
    public int insertOne(TestDO testDO);

    @Insert("update test set remark=#{remark} where id=#{id}")
    public int updateOne(TestDO testDO);


    //    @InsertProvider(type = Provider.class, method = "test")
    @Insert("<script> merge into test t1 using ( select #{testDao.id} as id,<foreach collection='subStrs' item='one' open='' separator='||' close=''>to_clob(#{one}) </foreach> as remark from dual)  t2 on(t1.id=t2.id)" +
            " when not matched then insert values(t2.id,t2.remark)</script>")
    public int test(@Param("testDao") TestDO testDO, @Param("subStrs") List<String> subStrs);//,@Param("") List<String>...subStr


    default public int merge(TestDO testDO) {
        String remark = testDO.getRemark();
        List<String> stringList = new ArrayList<>();
        int length = remark.length();
        int times = (int) Math.ceil(length / 1000.0);
        for (int j = 0; j < times; j++) {
            int start = j * 1000;
            int end = start + 1000;
            if (j == times - 1) {
                end = length;
            }
            stringList.add(remark.substring(start, end));
        }
        return test(testDO, stringList);
    }
//    public void test(@Param("subStrs")String...subStr);


    @InsertProvider(type = Provider.class, method = "mergeMany")
//    @SelectProvider(type = Provider.class, method = "mergeMany")
    public /*List<TestDO>*/int mergeMany(@Param("list") List<TestDO> list);

    @Insert("select ")
    public int testMany(@Param("list") List<TestDO> list);
}
