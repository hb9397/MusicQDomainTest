package com.kakao.musicqdomaintest.member.Dto;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotNull;


@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberInfoResDto {
    @NotNull
    private String id;

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private Long record;

    @NotNull
    private int games_count;

    @NotNull
    private int win_count;

    @NotNull
    @Builder.Default
    private MemberImageDto profile_img =  new MemberImageDto();
}
