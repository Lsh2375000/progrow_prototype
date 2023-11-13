package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.MenteeVO;
import com.example.mentoring_project.domain.MentorVO;
import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.dto.MentorDTO;
import com.example.mentoring_project.mapper.MenteeMapper;
import com.example.mentoring_project.mapper.MentorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
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
    public MentorDTO getOne(Long mentorNo) {
        log.info("MentorService getOne()...");

        MentorVO mentorVO = mentorMapper.selectOne(mentorNo);
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
    public void remove(Long mentorNo) {
        log.info("MentorService remove()....");
        mentorMapper.delete(mentorNo);
    }
}
