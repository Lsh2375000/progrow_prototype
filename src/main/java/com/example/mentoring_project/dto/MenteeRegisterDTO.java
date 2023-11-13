package com.example.mentoring_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenteeRegisterDTO {
    private Long menteeNo; // 멘티 넘버
    private String mentee_id; // 멘티 ID
    private String passwd; // 멘티 PW
    private String name; // 멘티 이름
    private String region; // 멘티 지역
    private int age; // 멘티 나이
    private String nickname; // 멘티 별명
    private String lngName; // 멘티 프로그래밍 언어
    private int mNo; // 멘토링 세션방 고유번호
    private int mNum; // 멘토링 참가 횟수
    private String type; // 멘토 , 멘티 타입

}