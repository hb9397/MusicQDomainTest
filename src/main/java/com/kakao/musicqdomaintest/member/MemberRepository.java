package com.kakao.musicqdomaintest.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberDomain, Long> {
    List<MemberDomain>findByEmail(String email);
    List<MemberDomain>findById(String id);
}
