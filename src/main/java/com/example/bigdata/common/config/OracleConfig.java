package com.example.bigdata.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.bigdata.dao.oracle"}, sqlSessionTemplateRef = "oracleSqlSessionTemplate")
public class OracleConfig {

    @Bean("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean("oracleSqlSessionTemplate")
    public SqlSessionTemplate oracleSqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    @Bean("oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations();
//        Properties properties=new Properties();
//        properties.setProperty("mapUnderscoreToCamelCase","true");
//        bean.setConfigurationProperties(properties);
//        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        bean.setConfiguration(configuration);

        bean.setConfigLocation(new ClassPathResource("mybatis.xml"));
//        bean.setConfigLocation(new Re"");
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:mapping/oracle/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean("oracleTransactionManager")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("oracleDataSource") DataSource oracleDataSource) throws Exception {
        return new DataSourceTransactionManager(oracleDataSource);
    }
}