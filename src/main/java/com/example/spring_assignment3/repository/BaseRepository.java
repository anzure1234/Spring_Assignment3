package com.example.spring_assignment3.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
@NoRepositoryBean
public interface BaseRepository<T,ID> extends CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>, JpaSpecificationExecutor<T> {

}
