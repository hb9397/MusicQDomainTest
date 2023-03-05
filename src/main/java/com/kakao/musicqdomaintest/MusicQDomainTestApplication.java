package com.kakao.musicqdomaintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusicQDomainTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicQDomainTestApplication.class, args);
    }

}
