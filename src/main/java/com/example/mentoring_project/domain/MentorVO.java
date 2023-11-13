package com.example.mentoring_project.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MentorVO {
    private Long mentorNo; // 멘토 고유 번호
    private String mentor_id; // 멘토 아이디
    private String passwd; // 비밀번호
    private String name; // 이름
    private String region; // 지역
    private int age; // 나이
    private String nickname; // 닉네임
    private String lngName; // 멘토전공 언어
    private String portfolio; // 멘토 포트폴리오
    private String intro; // 멘토 소개
    private int mNo; // 현재 참여하고 있는 멘토링방 번호
    private int gradeByMNum; // 멘토링 참여 횟수
    private String type; // 멘토 타입
}
