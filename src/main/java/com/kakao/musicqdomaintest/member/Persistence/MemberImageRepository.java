package com.kakao.musicqdomaintest.member.Persistence;

import com.kakao.musicqdomaintest.member.Domain.MemberImageDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberImageRepository extends JpaRepository<MemberImageDomain, Long> {
}
