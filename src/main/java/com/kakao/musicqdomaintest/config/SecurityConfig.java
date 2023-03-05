package com.kakao.musicqdomaintest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    // 비밀번호 암호화를 위한 메서드
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors().and()
                // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
                .csrf().disable()
                // JWT 토큰을 사용하므로(jwt 자체가 stateless 한 상태이므로) 서버단에서 세션을 사용하지 않기 때문에 STATELESS로 설정
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity
                .formLogin().disable();
                /*.oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorization")
                .authorizationRequestRepository(cookieAuthorizationRequestRepository).and()
                .redirectionEndpoint()
                .baseUri("/oauth2/callback/*").and()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
*/
        // ExceptionHandling 시 401, 403 에러에 대해서 예외에 대해 만든 클래스를 사용
        /*httpSecurity
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler);*/

        /*httpSecurity
                .authorizeHttpRequests() // HttpServletRequest 를 사용하는 요청에 대한 접근을 제한을 설정하기 위한 메서드
                // 2가지 URL 에 대해서는 제한없이 허용하겠다는 메서드, 로그인, 회원가입 에는 토큰이 없는 상태로 접근하기 때문
                .requestMatchers( "/favicon.ico","/error", "/api/authenticate","/api/signup", "/api/login").permitAll()
                // OAuth 로 부터 얻은 제공자 사이트에서 주는 인증 토큰확인 url, ouath 로그인 url 권한 없이 진입
                .requestMatchers("/auth/**", "/oauth2/**").permitAll()
                //.requestMatchers(PathRequest.toH2Console()).permitAll()
                // 위의 세가지 URL 을 제외한 요청에는 인증을 하겠다는 의미
                .anyRequest().authenticated();*/

        //httpSecurity.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class);

        // TokenProvider 를 시큐리티 로직에 등록하는 JwtFilter 를 addFilterBefore 메서드로 등록한 JwtSecurityConfig 적용
        //httpSecurity.apply(new JwtSecurityConfig(tokenProvider));

        return httpSecurity.build();
    }
}
