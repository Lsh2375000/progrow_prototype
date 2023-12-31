package com.example.mentoring_project.dto.mentoringDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorRoomNoticeDTO {
    Long num; // 공지 번호
    String mentor_id; // 멘토 id;
    String title; // 제목
    String content; // 내용
    private LocalDateTime addDate; // 등록시간
    //    int a=0;
}
