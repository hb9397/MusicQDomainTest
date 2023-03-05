package com.kakao.musicqdomaintest.member.Dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotNull;

@Log4j2
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoCUDto {
    @NotNull
    private String id;

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String password;


    private final MemberImageDto memberImageDto = new MemberImageDto();

}
