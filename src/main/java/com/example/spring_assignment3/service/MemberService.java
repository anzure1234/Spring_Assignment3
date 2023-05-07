package com.example.spring_assignment3.service;

import com.example.spring_assignment3.entity.Member;

import java.util.Optional;

public interface MemberService {
    void create(Member member);

    void save(Member member);

    Optional<Member> findById(Long id);












}
