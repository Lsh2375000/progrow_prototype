package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.SMemberVO;
import com.example.mentoring_project.dto.MemberJoinDTO;
import com.example.mentoring_project.mapper.SMemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SMemberServiceImpl implements SMemberService {

    private final SMemberMapper sMemberMapper;
    private final ModelMapper modelMapper;

    @Override
    public void add(MemberJoinDTO memberJoinDTO) { // 회원 가입

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberJoinDTO.setMpw(passwordEncoder.encode(memberJoinDTO.getMpw())); // 비밀번호 암호화

        SMemberVO memberVO = modelMapper.map(memberJoinDTO, SMemberVO.class);

        log.info("memberVO : " + memberVO);

        sMemberMapper.addMember(memberVO);
        Integer role_set = 0; // 뷰로 회원가입할 때 자동으로 ROLE_USER 로 등록
        sMemberMapper.addMemberRole(memberJoinDTO.getMid(), role_set);

    }

    @Override
    public SMemberVO getMemberId(String mid) {
        return sMemberMapper.getMemberId(mid);
    }

    @Override
    public void modifyPassword(String mpw, String mid) { // 회원 비밀번호 수정
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String updateMpw = passwordEncoder.encode(mpw);

        sMemberMapper.updatePassword(updateMpw, mid);
    }


}
