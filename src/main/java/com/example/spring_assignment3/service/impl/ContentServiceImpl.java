package com.example.spring_assignment3.service.impl;

import com.example.spring_assignment3.entity.Content;
import com.example.spring_assignment3.repository.ContentRepository;
import com.example.spring_assignment3.service.ContentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }
    @Override
    public void create(Content content) {
        content.setCreatedDate(LocalDateTime.now());
        content.setLastModifiedDate(LocalDateTime.now());
        contentRepository.save(content);
    }

    @Override
    public void save(Content content) {
        content.setLastModifiedDate(LocalDateTime.now());
        contentRepository.save(content);
    }

    @Override
    public List<Content> findAll() {
        return (List<Content>) contentRepository.findAll();
    }


    @Override
    public Page<Content> findAllPaging(Specification<Content> specification, Pageable pageable) {
        return contentRepository.findAll(specification, pageable);
    }

}
