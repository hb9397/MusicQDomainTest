package com.kakao.musicqdomaintest.member.Domain;

import com.kakao.musicqdomaintest.common.BaseDomain;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Log4j2
@ToString
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Where(clause = "deleted_at is NULL")
@SQLDelete(sql = "update member set deleted_at = CURRENT_TIMESTAMP where member_id = ?")
@Table(name = "member")
@Entity
public class MemberDomain extends BaseDomain {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private Long record = 0L;

    @Column(nullable = false)
    @Builder.Default
    private int games_count = 0;

    @Column(nullable = false)
    @Builder.Default
    private int win_count = 0;

    private String refresh_token;

    /*@Builder
    public MemberDomain(String id, String email, String nickname, String password, Long record, int games_count, int win_count, String refresh_token){
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.record = record;
        this.games_count = games_count;
        this.win_count = win_count;
        this.refresh_token = refresh_token;
    }*/
}
