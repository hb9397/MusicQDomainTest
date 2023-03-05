package com.kakao.musicqdomaintest.member.Controller;

import com.kakao.musicqdomaintest.member.Dto.MemberInfoCUDto;
import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;
import com.kakao.musicqdomaintest.member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberRestController {
    private final MemberService memberService;

    @PostMapping("signup")
    public ResponseEntity<MemberInfoResDto> signup(
            @Valid @RequestBody MemberInfoCUDto memberInfoCUDto
            ){
        return ResponseEntity.ok(memberService.signup(memberInfoCUDto));
    }
}
