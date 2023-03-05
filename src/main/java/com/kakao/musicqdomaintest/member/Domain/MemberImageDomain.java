package com.kakao.musicqdomaintest.member.Domain;


import lombok.*;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@ToString(exclude = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "member_image")
@Entity
public class MemberImageDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;


    private String profile_img;

    @OneToOne(fetch = FetchType.LAZY)
    private MemberDomain memberDomain;
}
