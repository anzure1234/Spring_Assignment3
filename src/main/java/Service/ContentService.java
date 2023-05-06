package Service;

import Entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContentService {
    void create(Content content);

    void save(Content content);



    Page<Content> findAllPaging(Specification<Content> specification, Pageable pageable);



}
