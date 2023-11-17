package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.MenteeVO;
import com.example.mentoring_project.domain.MentoringVO;
import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.dto.MentoringDTO;
import com.example.mentoring_project.mapper.MenteeMapper;
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
public class MenteeServiceImpl implements MenteeService{

    private final MenteeMapper menteeMapper;
    private final ModelMapper modelMapper;

    @Override
    public void add(MenteeDTO menteeDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        log.info("service add()...");
        log.info(menteeDTO);
        menteeDTO.setPasswd(passwordEncoder.encode(menteeDTO.getPasswd()));
        MenteeVO menteeVO = modelMapper.map(menteeDTO, MenteeVO.class);
        menteeMapper.insert(menteeVO);
    }

    @Override
    public List<MenteeDTO> getAll() {
        log.info("service getAll()...");

        List<MenteeVO> menteeVOList = menteeMapper.selectAll();
        List<MenteeDTO> menteeDTOList = new ArrayList<>();
        menteeVOList.forEach(menteeVO -> menteeDTOList.add(modelMapper.map(menteeVO, MenteeDTO.class)));
        return menteeDTOList;
    }



    @Override
    public MenteeDTO getOne(Long menteeNo) {
        log.info("service getOne()...");
        MenteeVO menteeVO = menteeMapper.selectOne(menteeNo);
        MenteeDTO menteeDTO = modelMapper.map(menteeVO, MenteeDTO.class);
        return menteeDTO;
    }


    @Override
    public void modify(MenteeDTO menteeDTO) {
        log.info("service modify()...");

        MenteeVO menteeVO = modelMapper.map(menteeDTO, MenteeVO.class);
        menteeMapper.update(menteeVO);
    }



    @Override
    public void remove(Long menteeNo) {
        log.info("service remove()....");
        menteeMapper.delete(menteeNo);
    }



}
