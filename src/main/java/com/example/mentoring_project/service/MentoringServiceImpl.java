package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.MentoringVO;
import com.example.mentoring_project.dto.MentoringDTO;
import com.example.mentoring_project.mapper.MentoringMapper;
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
    public List<MentoringDTO> getAll() {
        List<MentoringVO> mentoringVOList = mentoringMapper.selectAll();
        List<MentoringDTO> mentoringDTOList = new ArrayList<>();
        mentoringVOList.forEach(mentoringVO -> mentoringDTOList.add(modelMapper.map(mentoringVO, MentoringDTO.class)));
        return mentoringDTOList;
    }
}
