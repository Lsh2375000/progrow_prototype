package com.example.mentoring_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorRegisterDTO {
    private Long mentorNo; // 멘토 넘버
    private String mentee_id; // 멘토 ID
    private String passwd; // 멘토 PW
    private String name; // 멘토 이름
    private String region; // 멘토 지역
    private int age; // 멘토 나이
    private String nickname; // 멘토 닉네임
    private String lngName; // 멘토 프로그래밍 언어
    private String portfolio; // 멘토 포트폴리오
    private String intro; // 멘토 소개
    private int mNo; // 멘토링 세션방 고유번호
    private int gradeByMNum; // 멘토링 횟수(횟수에 따라 멘토링 등급 반여)
    private String type; // 멘토, 멘티 타입
}