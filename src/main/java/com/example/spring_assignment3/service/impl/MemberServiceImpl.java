package com.example.spring_assignment3.service.impl;

import com.example.spring_assignment3.entity.Member;
import com.example.spring_assignment3.repository.MemberRepository;
import com.example.spring_assignment3.service.MemberService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void create(Member member) {
        member.setCreatedDate(LocalDateTime.now());
        member.setLastModifiedDate(LocalDateTime.now());
        memberRepository.save(member);
    }

    @Override
    public void save(Member member) {
        member.setLastModifiedDate(LocalDateTime.now());
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }


}
