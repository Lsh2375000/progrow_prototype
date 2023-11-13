package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.MemberVO;
import com.example.mentoring_project.domain.MenteeVO;
import com.example.mentoring_project.dto.MemberDTO;
import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberMapper memberMapper;

    @Override
    public void add(MemberDTO memberDTO) {
        log.info("MemberService add()...");
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberMapper.insert(memberVO);
    }

}

