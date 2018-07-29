package com.example.bigdata.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class MultiTransactionConfig {
    @Bean("multiTransactionManager")
    public ChainedTransactionManager multiTransactionManager(
            @Qualifier("oracleTransactionManager") DataSourceTransactionManager oracleTX,
            @Qualifier("mysqlTransactionManager") DataSourceTransactionManager mysqlTX,
            @Qualifier("neo4jTransactionManager") Neo4jTransactionManager neo4jTransactionManager){
        ChainedTransactionManager multiTX=new ChainedTransactionManager(
                oracleTX,mysqlTX,neo4jTransactionManager);
        return multiTX;
    }
}
