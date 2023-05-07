package com.example.spring_assignment3.service;

import com.example.spring_assignment3.entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContentService {
    void create(Content content);

    void save(Content content);

    List<Content> findAll();

    Page<Content> findAllPaging(Specification<Content> specification, Pageable pageable);



}
