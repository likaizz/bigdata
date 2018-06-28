package com.example.bigdata.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.web.support.OpenSessionInViewInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.example.bigdata.repository.neo4j")
@EnableTransactionManagement
public class Neo4jConfig {
    @Value("${spring.data.neo4j.uri}")
    private String URI;
    @Value("${spring.data.neo4j.username}")
    private String UAERNAME;
    @Value("${spring.data.neo4j.password}")
    private String PASSWORD;

    @Bean
    public OpenSessionInViewInterceptor openSessionInViewInterceptor() {
        OpenSessionInViewInterceptor openSessionInViewInterceptor =
                new OpenSessionInViewInterceptor();
        openSessionInViewInterceptor.setSessionFactory(neo4jSessionFactory());
        return openSessionInViewInterceptor;
    }

    @Bean("neo4jConfiguration")
    public org.neo4j.ogm.config.Configuration neo4jConfiguration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(URI)
                .credentials(UAERNAME, PASSWORD)
                .build();
        return configuration;
    }

    @Bean( {"getSessionFactory","neo4jSessionFactory"})
    public SessionFactory neo4jSessionFactory() {
        return new SessionFactory(neo4jConfiguration(), "com.example.bigdata.domain");
    }

    @Bean({"transactionManager","neo4jTransactionManager"})
    public Neo4jTransactionManager neo4jTransactionManager() throws Exception {
        return new Neo4jTransactionManager(neo4jSessionFactory());
    }
}