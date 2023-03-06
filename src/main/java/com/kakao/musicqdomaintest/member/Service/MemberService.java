package com.kakao.musicqdomaintest.member.Service;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;
import com.kakao.musicqdomaintest.member.Domain.MemberImageDomain;
import com.kakao.musicqdomaintest.member.Dto.MemberImageDto;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface MemberService {
    default Map<String, Object> memberinfoToEntity(String memberInfoCUDto){
        Map<String, Object> entityMap = new HashMap<>();
        JSONObject memberInfo = new JSONObject(memberInfoCUDto);

        MemberDomain memberDomain = MemberDomain.builder()
                .id(memberInfo.getString("id"))
                .email(memberInfo.getString("email"))
                .nickname(memberInfo.getString("nickname"))
                .password(memberInfo.getString("password"))
                .build();

        entityMap.put("member", memberDomain);


        MemberImageDomain memberImageDomain = MemberImageDomain.builder()
                .profile_img("a.img")
                .memberDomain(memberDomain)
                .build();
        entityMap.put("member_image", memberImageDomain);

        return entityMap;
    }

    default MemberInfoResDto entityToMemberInfoRes(MemberDomain memberDomain, MemberImageDomain memberImageDomain){

        MemberImageDto memberImageDto = MemberImageDto.builder()
                .profile_img(memberImageDomain.getProfile_img())
                .build();

        MemberInfoResDto memberInfoResDto = MemberInfoResDto.builder()
                .id(memberDomain.getId())
                .email(memberDomain.getEmail())
                .nickname(memberDomain.getNickname())
                .password(memberDomain.getPassword())
                .record(memberDomain.getRecord())
                .games_count(memberDomain.getGames_count())
                .win_count(memberDomain.getWin_count())
                .profile_img(memberImageDto)
                .build();

        return memberInfoResDto;
    }
    MemberInfoResDto signup(String memberInfoReq);
    Long findId(String id);
    Long findEmail(String email);
    Long findNickname(String nickname);
}
