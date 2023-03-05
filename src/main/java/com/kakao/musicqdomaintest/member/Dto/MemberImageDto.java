package com.kakao.musicqdomaintest.member.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberImageDto {
    @Builder.Default
    private String profile_img = "a.img";
}
