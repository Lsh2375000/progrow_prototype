package com.example.mentoring_project.domain.mentoringVO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MentoringVO {
    private Long mNo; // 멘토링 세션방 고유 번호
    private String mentor_id; // 멘토 아이디
    private String mentee_id; // 멘티 아이디
//    private int maxNumPeople; // 최대 인원 설정
//    private int menteeNum; // 현재 모집된 멘티수
    private String region; // 오프라인일 경우 모일 지역
    private String lngName; // 멘토가 가르칠 프로그래밍 언어
    private String cLog; // 채팅 로그
    private String mData; // 멘토링 진행하면서 올리는 자료
    private boolean meeting; // 사전 만남 여부(1회만 가능)
    private boolean on_off; // 온 / 오프라인 여부
    private LocalDateTime addDate; // 기능 제공할 기간(기본 제공 두달)
    private int roomNo; // 공간 대여 했을 시 방 번호
    private boolean payment; // 결제 여부
}
