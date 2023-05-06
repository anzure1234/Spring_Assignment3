package Service.Impl;

import Entity.Member;
import Repository.MemberRepository;
import Service.MemberService;

import java.time.LocalDateTime;
import java.util.List;

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
}
