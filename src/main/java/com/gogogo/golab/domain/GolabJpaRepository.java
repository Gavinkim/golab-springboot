package com.gogogo.golab.domain;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GolabJpaRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,
    QuerydslPredicateExecutor<T>, JpaSpecificationExecutor<T> {

}
