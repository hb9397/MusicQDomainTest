package com.kakao.musicqdomaintest.member.Persistence;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberDomain, Long> {
    List<MemberDomain>findByEmail(String email);
    List<MemberDomain>findById(String id);
}
