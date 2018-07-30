package com.example.bigdata.common.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

/**
 * 配置neo4j的数据源
 */
@Configuration
@EntityScan("com.example.bigdata.entity")
@EnableNeo4jRepositories(basePackages = "com.example.bigdata.dao.neo4j")
public class Neo4jConfig {
//    @Value("${spring.data.neo4j.uri}")
//    private  String URI;
//    @Value("${spring.data.neo4j.username}")
//    private  String UAERNAME;
//    @Value("${spring.data.neo4j.password}")
//    private  String PASSWORD;
//    @Bean("neo4jConfiguration")
//    public org.neo4j.ogm.config.Configuration configuration() {
//        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
//                .uri(URI)
//                .credentials(UAERNAME, PASSWORD)
//                .build();
//        return configuration;
//    }
    @Bean({/*"transactionManager",*/"neo4jTransactionManager"})
    public Neo4jTransactionManager transactionManager(@Autowired SessionFactory sessionFactory) throws Exception {
        //return new JtaTransactionManagerFactoryBean();
        return new Neo4jTransactionManager(sessionFactory);
    }
//    @Bean({"sessionFactory",/*"getSessionFactory",*/"neo4jSessionFactory"})
//    public SessionFactory sessionFactory() {
//        SessionFactory sessionFactory= new SessionFactory(configuration(),"com.example.bigdata.dao.neo4j");//"com.example.mongoapp.dao.neo4j""com.example.mongoapp.entity"
//        return sessionFactory;
//    }


}
