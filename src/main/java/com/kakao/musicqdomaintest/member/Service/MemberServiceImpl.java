package com.kakao.musicqdomaintest.member.Service;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;
import com.kakao.musicqdomaintest.member.Domain.MemberImageDomain;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoCUDto;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;
import com.kakao.musicqdomaintest.member.Persistence.MemberImageRepository;
import com.kakao.musicqdomaintest.member.Persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final MemberImageRepository memberImageRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberInfoResDto signup(MemberInfoCUDto memberInfoCUDto) {
        if(memberRepository.findByEmail(memberInfoCUDto.getEmail()) != null) {
            log.warn("이미 있어");
        }

        Map<String,Object> entityMap = memberinfoToEntity(memberInfoCUDto);

        MemberDomain memberDomain = (MemberDomain) entityMap.get("member");
        memberDomain.setPassword(passwordEncoder.encode(memberInfoCUDto.getPassword()));

        MemberImageDomain memberImageDomain = (MemberImageDomain) entityMap.get("member_image");

        memberRepository.save(memberDomain);
        memberImageRepository.save(memberImageDomain);

        MemberInfoResDto memberInfoResDto = entityToMemberInfoRes(memberDomain, memberImageDomain);

        return memberInfoResDto;
    }
}
