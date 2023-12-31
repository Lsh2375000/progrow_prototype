package com.example.mentoring_project.service.mentoringService;


import com.example.mentoring_project.domain.mentoringVO.MentorRoomNoticeVO;

import com.example.mentoring_project.domain.mentoringVO.MentoringVO;
import com.example.mentoring_project.domain.memberVO.MenteeVO;
import com.example.mentoring_project.domain.memberVO.MentorVO;
import com.example.mentoring_project.dto.memberDTO.MenteeDTO;
import com.example.mentoring_project.dto.memberDTO.MentorDTO;
import com.example.mentoring_project.dto.mentoringDTO.MentorRoomNoticeDTO;
import com.example.mentoring_project.dto.mentoringDTO.MentoringDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.mapper.mentoringMapper.MentoringMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MentoringServiceImpl implements MentoringService{
    private final MentoringMapper mentoringMapper;
    private final ModelMapper modelMapper;
    @Override
    public void add(MentoringDTO mentoringDTO) {
        MentoringVO mentoringVO = modelMapper.map(mentoringDTO, MentoringVO.class);
        mentoringMapper.insert(mentoringVO);
    }
    @Override
    public void isMentoringMentor(MentorDTO mentorDTO) {
        MentorVO mentorVO = modelMapper.map(mentorDTO, MentorVO.class);
        mentoringMapper.mentorIsMentoring(mentorVO);
    }

    @Override
    public boolean isMentorMentoring(String mentor_id) {
        return mentoringMapper.isMentorMentoring(mentor_id);
    }

    @Override // 멘토의 멘토링 방 조회
    public MentoringDTO mentorRoom(String mentor_id) {
        MentoringVO mentoringVO = mentoringMapper.mentorRoom(mentor_id);
        MentoringDTO mentoringDTO = modelMapper.map(mentoringVO, MentoringDTO.class);
        return mentoringDTO;
    }

    @Override
    public void recruitAdd(MentoringDTO mentoringDTO) {
        MentoringVO mentoringVO = modelMapper.map(mentoringDTO, MentoringVO.class);
        mentoringMapper.recruitInsert(mentoringVO);
    }

    @Override
    public void recruitMentee(MenteeDTO menteeDTO) { // 멘티의 멘토링 가입 시 user_mentee 테이블의 isMentoring 컬럼 true 로 변경, mNo 저장
        MenteeVO menteeVO = modelMapper.map(menteeDTO, MenteeVO.class);
        mentoringMapper.menteeRecruit(menteeVO);
    }

    @Override
    public boolean isMenteeMentoring(String mentee_id) {
        return mentoringMapper.isMenteeMentoring(mentee_id);
    }

    @Override
    public MentoringDTO menteeRoom(String mentee_id) {
        MentoringVO mentoringVO = mentoringMapper.menteeRoom(mentee_id);
        MentoringDTO mentoringDTO = modelMapper.map(mentoringVO, MentoringDTO.class);
        return mentoringDTO;
    }

//
//    @Override
//    public MenteeDTO menteeIsMentoring(String mentee_id) {
//        MenteeVO menteeVO = mentoringMapper.getMenteeIsMentoring(mentee_id);
//        MenteeDTO menteeDTO = modelMapper.map(menteeVO, MenteeDTO.class);
//        return menteeDTO;
//    }

    @Override
    public List<MentoringDTO> getAll() {
        List<MentoringVO> mentoringVOList = mentoringMapper.selectAll();
        List<MentoringDTO> mentoringDTOList = new ArrayList<>();
        mentoringVOList.forEach(mentoringVO -> mentoringDTOList.add(modelMapper.map(mentoringVO, MentoringDTO.class)));
        return mentoringDTOList;
    }

    @Override
    public PageResponseDTO<MentoringDTO> getList(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();

        List<MentoringVO> voList = mentoringMapper.selectList(pageRequestDTO);
        List<MentoringDTO> dtoList = new ArrayList<>();
        for (MentoringVO mentoringVO : voList) {
            dtoList.add(modelMapper.map(mentoringVO, MentoringDTO.class));
        }
        int total = mentoringMapper.getCount(pageRequestDTO);
        PageResponseDTO<MentoringDTO> pageResponseDTO = PageResponseDTO.<MentoringDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

    @Override
    public MentoringDTO getOne(Long mNo) {
        MentoringVO mentoringVO = mentoringMapper.selectOne(mNo);
        MentoringDTO mentoringDTO = modelMapper.map(mentoringVO, MentoringDTO.class);
        return mentoringDTO;
    }

    @Override   // 멘토룸 공지사항 작성(멘토)
    public void addNotice(MentorRoomNoticeDTO mentorRoomNoticeDTO) {
        MentorRoomNoticeVO mentorRoomNoticeVO = modelMapper.map(mentorRoomNoticeDTO, MentorRoomNoticeVO.class);
        mentoringMapper.insertNotice(mentorRoomNoticeVO);
    }

    @Override // 멘토룸 공지사항 수정
    public void modifyNotice(MentorRoomNoticeDTO mentorRoomNoticeDTO) {
        MentorRoomNoticeVO mentorRoomNoticeVO = modelMapper.map(mentorRoomNoticeDTO, MentorRoomNoticeVO.class);
        mentoringMapper.updateNotice(mentorRoomNoticeVO);
    }

    @Override // 멘토룸 공지사항 삭제
    public void removeNotice(Long num) {
        mentoringMapper.deleteNotice(num);
    }


    @Override
    public List<MentorRoomNoticeDTO> getAllNotice() {
        List<MentorRoomNoticeVO> mentorRoomNoticeVOList = mentoringMapper.selectAllNotice();
        List<MentorRoomNoticeDTO> mentorRoomNoticeDTOList = new ArrayList<>();
        mentorRoomNoticeVOList.forEach(mentorRoomNoticeVO -> mentorRoomNoticeDTOList.add(modelMapper.map(mentorRoomNoticeVO, MentorRoomNoticeDTO.class)));
        return mentorRoomNoticeDTOList;
    }

    @Override
    public MentorRoomNoticeDTO getOneNotice(Long num) {
        MentorRoomNoticeVO mentorRoomNoticeVO = mentoringMapper.selectOneNotice(num);
        MentorRoomNoticeDTO mentorRoomNoticeDTO = modelMapper.map(mentorRoomNoticeVO, MentorRoomNoticeDTO.class);
        return mentorRoomNoticeDTO;
    }


    @Override   // 멘토링 수정
    public void modifyOne(MentoringDTO mentoringDTO) {
        MentoringVO mentoringVO = modelMapper.map(mentoringDTO, MentoringVO.class);
        mentoringMapper.update(mentoringVO);
    }

    @Override // 멘토링 삭제
    public void removeOne(Long mNo) {
        mentoringMapper.delete(mNo);
    }


}