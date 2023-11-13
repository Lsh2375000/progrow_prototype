package com.example.mentoring_project.domain;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatVO {
    private Long chatNo; // 채팅방 고유 번호
    private String cLog; // 채팅 로그

}
