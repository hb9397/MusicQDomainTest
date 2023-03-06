package com.kakao.musicqdomaintest.member.Controller;

import com.kakao.musicqdomaintest.member.Dto.MemberInfoResDto;
import com.kakao.musicqdomaintest.member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberRestController {
    private final MemberService memberService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<MemberInfoResDto> signup(
            @Valid @RequestBody String memberInfoReq
            ){
        return ResponseEntity.ok(memberService.signup(memberInfoReq));
    }

    @GetMapping("/id")
    public ResponseEntity<Long> checkId(
        @Valid @RequestBody String id
        ){
        return ResponseEntity.ok(memberService.findId(id));
    }


    @PostMapping("/email")
    public ResponseEntity<Long> checkEmail(
        @Valid @RequestBody String email
    ){
        return ResponseEntity.ok(memberService.findEmail(email));
    }

    @GetMapping("/nickname")
    public ResponseEntity<String> checkNickname(){
        return null;
    }
}
