package com.example.mentoring_project.service.memberService;


import com.example.mentoring_project.domain.memberVO.MentorVO;
import com.example.mentoring_project.dto.memberDTO.MentorDTO;
import com.example.mentoring_project.mapper.memberMapper.MentorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MentorServiceImpl implements MentorService{
    private final MentorMapper mentorMapper;
    private final ModelMapper modelMapper;

    @Override
    public void add(MentorDTO mentorDTO) {
        log.info("MentorService add()...");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mentorDTO.setPasswd(passwordEncoder.encode(mentorDTO.getPasswd()));

        MentorVO mentorVO = modelMapper.map(mentorDTO, MentorVO.class);
        mentorMapper.insert(mentorVO);
    }

    @Override
    public List<MentorDTO> getAll() {
        log.info("MentorService getAll()...");

        List<MentorVO> mentorVOList = mentorMapper.selectAll();
        List<MentorDTO> mentorDTOList = new ArrayList<>();
        mentorVOList.forEach(mentorVO -> mentorDTOList.add(modelMapper.map(mentorVO, MentorDTO.class)));
        return mentorDTOList;
    }



    @Override
    public MentorDTO getOne(String mentor_id) {
        log.info("MentorService getOne()...");

        MentorVO mentorVO = mentorMapper.selectOne(mentor_id);
        MentorDTO mentorDTO = modelMapper.map(mentorVO, MentorDTO.class);
        return mentorDTO;
    }


    @Override
    public void modify(MentorDTO mentorDTO) {
        log.info("MentorService modify()...");

        MentorVO mentorVO = modelMapper.map(mentorDTO, MentorVO.class);
        mentorMapper.update(mentorVO);
    }



    @Override
    public void remove(String mentor_id) {
        log.info("MentorService remove()....");
        mentorMapper.delete(mentor_id);
    }

    @Override
    public void modifyPw(String passwd, String mentor_id) {
        log.info("Mentor Service ModifyPw()...");
        mentorMapper.updatePw(passwd, mentor_id);
    }
}
