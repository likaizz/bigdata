package com.example.bigdata.repository.neo4j;

import com.example.bigdata.domain.neo4j.Emp;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeoEmpRepository extends Neo4jRepository<Emp,Long> {
}
