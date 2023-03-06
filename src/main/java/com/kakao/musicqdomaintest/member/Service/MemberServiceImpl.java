package com.kakao.musicqdomaintest.member.Service;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;
import com.kakao.musicqdomaintest.member.Domain.MemberImageDomain;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;
import com.kakao.musicqdomaintest.member.Persistence.MemberImageRepository;
import com.kakao.musicqdomaintest.member.Persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.json.JSONObject;
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
    public MemberInfoResDto signup(String memberInfoReq) {
        System.out.println(memberInfoReq);
        JSONObject memberInfo = new JSONObject(memberInfoReq);

        if(memberRepository.findByEmail(memberInfo.getString("email")) != null) {
            log.warn("이미 있어");
        }

        Map<String,Object> entityMap = memberinfoToEntity(memberInfoReq);

        MemberDomain memberDomain = (MemberDomain) entityMap.get("member");
        memberDomain.setPassword(passwordEncoder.encode(memberInfo.getString("password")));

        MemberImageDomain memberImageDomain = (MemberImageDomain) entityMap.get("member_image");

        memberRepository.save(memberDomain);
        memberImageRepository.save(memberImageDomain);

        MemberInfoResDto memberInfoResDto = entityToMemberInfoRes(memberDomain, memberImageDomain);

        return memberInfoResDto;
    }

    @Override
    public Long findId(String id) {
        return memberRepository.countById(id);
    }

    @Override
    public Long findEmail(String email) {
        return memberRepository.countByEmail(email);
    }

    @Override
    public Long findNickname(String nickname) {
        return memberRepository.countByNickname(nickname);
    }
}
