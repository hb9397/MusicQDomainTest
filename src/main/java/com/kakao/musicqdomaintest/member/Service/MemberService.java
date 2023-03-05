package com.kakao.musicqdomaintest.member.Service;

import com.kakao.musicqdomaintest.member.Domain.MemberDomain;
import com.kakao.musicqdomaintest.member.Domain.MemberImageDomain;
import com.kakao.musicqdomaintest.member.Dto.MemberImageDto;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoCUDto;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface MemberService {
    default Map<String, Object> memberinfoToEntity(MemberInfoCUDto memberInfoCUDto){
        Map<String, Object> entityMap = new HashMap<>();

        MemberDomain memberDomain = MemberDomain.builder()
                .id(memberInfoCUDto.getId())
                .email(memberInfoCUDto.getEmail())
                .nickname(memberInfoCUDto.getNickname())
                .password(memberInfoCUDto.getPassword())
                .build();

        entityMap.put("member", memberDomain);

        MemberImageDto memberImageDto = memberInfoCUDto.getMemberImageDto();

        MemberImageDomain memberImageDomain = MemberImageDomain.builder()
                .profile_img(memberImageDto.getProfile_img())
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

    MemberInfoResDto signup(MemberInfoCUDto memberInfoCUDto);
}
