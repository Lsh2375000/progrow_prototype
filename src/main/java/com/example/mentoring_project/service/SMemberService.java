package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.SMemberVO;
import com.example.mentoring_project.dto.MemberJoinDTO;

import java.util.List;

public interface SMemberService {

    void add(MemberJoinDTO memberJoinDTO);

    SMemberVO getMemberId(String mid);

//    SMemberVO getMemberEmail(String email);

    void modifyPassword(String mpw, String mid);

}
