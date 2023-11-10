package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.MenteeRegisterVO;
import com.example.mentoring_project.dto.MenteeRegisterDTO;
import com.example.mentoring_project.mapper.MenteeRegisterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class MenteeRegisterServiceImpl implements MenteeRegisterService{
    private final ModelMapper modelMapper;
    private final MenteeRegisterMapper menteeRegisterMapper;

    @Override
    public void add(MenteeRegisterDTO menteeRegisterDTO) {
        menteeRegisterMapper.insert(modelMapper.map(menteeRegisterMapper, MenteeRegisterVO.class));
    }

    @Override
    public List<MenteeRegisterDTO> getAll() {
        List<MenteeRegisterVO> menteeRegisterVOList = menteeRegisterMapper.selectAll();
        List<MenteeRegisterDTO> menteeRegisterDTOList = new ArrayList<>();
        menteeRegisterVOList.forEach(menteeRegisterVO -> menteeRegisterDTOList.add(modelMapper.map(menteeRegisterVO, MenteeRegisterDTO.class)));
        return menteeRegisterDTOList;
    }

    @Override
    public MenteeRegisterDTO getOne(Long menteeNo, String mode) {
        MenteeRegisterDTO menteeRegisterDTO = modelMapper.map(menteeRegisterMapper.selectOne(menteeNo), MenteeRegisterDTO.class);
        return menteeRegisterDTO;
    }

    @Override
    public void modifyOne(MenteeRegisterDTO menteeRegisterDTO) {
        menteeRegisterMapper.update(modelMapper.map(menteeRegisterDTO, MenteeRegisterVO.class));
    }

    @Override
    public void removeOne(Long menteeNo) {
        menteeRegisterMapper.delete(menteeNo);
    }


}
