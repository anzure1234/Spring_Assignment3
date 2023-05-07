package com.example.spring_assignment3.repository;

import com.example.spring_assignment3.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends BaseRepository<Member,Long>{

}
