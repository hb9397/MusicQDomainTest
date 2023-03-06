package com.kakao.musicqdomaintest.member.Persistence;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberDomain, Long> {
    List<MemberDomain>findByEmail(String memberInfoCuDto);
    List<MemberDomain>findById(String id);

    Long countById(String id);
    Long countByEmail(String email);
    Long countByNickname(String nickname);
}
