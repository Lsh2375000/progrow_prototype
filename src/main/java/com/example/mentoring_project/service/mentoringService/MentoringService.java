package com.example.mentoring_project.service.mentoringService;


import com.example.mentoring_project.dto.mentoringDTO.MentorRoomNoticeDTO;
import com.example.mentoring_project.dto.mentoringDTO.MentoringDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.memberDTO.MenteeDTO;
import com.example.mentoring_project.dto.memberDTO.MentorDTO;


import java.util.List;

public interface MentoringService {

    // <멘토>
    void add(MentoringDTO mentoringDTO); // 멘토의 멘토링 방 생성
    void isMentoringMentor(MentorDTO mentorDTO); // 멘토의 멘토링 방 생성 시 user_mentor 테이블의 isMentoring 컬럼 true 로 변경
    boolean isMentorMentoring(String mentor_id); // 멘토의 멘토링 생성 여부 조회
    MentoringDTO mentorRoom(String mentor_id); // 멘토의 멘토링 방정보 조회
    //

    // <멘티>다
    void recruitAdd(MentoringDTO mentoringDTO); // 멘티의 멘토링 가입
    void recruitMentee(MenteeDTO menteeDTO); // 멘티의 멘토링 가입 시 user_mentee 테이블의 isMentoring 컬럼 true 로 변경, mNo 저장
//    MenteeDTO menteeIsMentoring(String mentee_id);
    boolean isMenteeMentoring(String mentee_id); // 멘티의 멘토링여부 조회
    MentoringDTO menteeRoom(String mentee_id); // 멘티의 멘토링 방정보 조회
    //

    List<MentoringDTO> getAll(); // 멘토링 방 전체 목록

    PageResponseDTO<MentoringDTO> getList(PageRequestDTO pageRequestDTO);

    MentoringDTO getOne(Long mNo);

    void modifyOne(MentoringDTO mentoringDTO);

    void removeOne(Long mNo);

    // 멘토 멘토링 방의 멘토가 공지사항 작성
    void addNotice(MentorRoomNoticeDTO mentorRoomNoticeDTO);
    void modifyNotice(MentorRoomNoticeDTO mentorRoomNoticeDTO); // 멘토 멘토링 방의 멘토가 공지사항 수정
    void removeNotice(Long num); // 멘토 멘토링 방의 멘토가 공지사항 삭제
    
    List<MentorRoomNoticeDTO> getAllNotice(); // 멘토링룸 공지사항 리스트

    MentorRoomNoticeDTO getOneNotice(Long num);
}
