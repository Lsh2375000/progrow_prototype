package com.example.mentoring_project.domain;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
    private Long memberNo;
    private String id;
    private String name;
    private String region;
    private String type;
    private int age;
    private String nickname;
}
