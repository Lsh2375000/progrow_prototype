package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.MentorRegisterVO;
import com.example.mentoring_project.dto.MentorRegisterDTO;
import com.example.mentoring_project.mapper.MentorRegisterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MentorRegisterServiceImpl implements MentorRegisterService {

    private final ModelMapper modelMapper;
    private final MentorRegisterMapper mentorRegisterMapper;

    @Override
    public void add(MentorRegisterDTO mentorRegisterDTO) {
        mentorRegisterMapper.insert(modelMapper.map(mentorRegisterMapper, MentorRegisterVO.class));
    }

    @Override
    public MentorRegisterDTO getOne(Long mentorNo, String mode) {
        MentorRegisterDTO mentorRegisterDTO = modelMapper.map(mentorRegisterMapper.selectOne(mentorNo), MentorRegisterDTO.class);
        return mentorRegisterDTO;
    }

    @Override
    public void modifyOne(MentorRegisterDTO menteeRegisterDTO) {
        mentorRegisterMapper.update(modelMapper.map(mentorRegisterMapper, MentorRegisterVO.class));
    }

    @Override
    public void removeOne(Long memtorNo) {
        mentorRegisterMapper.delete(memtorNo);
    }

}
