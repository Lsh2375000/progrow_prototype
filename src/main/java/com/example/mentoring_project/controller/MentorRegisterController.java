package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MentorRegisterDTO;
import com.example.mentoring_project.service.MentorRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mentorRegister")
@Log4j2
@RequiredArgsConstructor
public class MentorRegisterController {
    private final MentorRegisterService mentorRegisterService;

    @GetMapping("/mentorRegister")
    public void add() {
        log.info("회원가입");
    }

    @PostMapping("/mentorRegister")
    public String addPost(MentorRegisterDTO mentorRegisterDTO, HttpServletRequest request) {
        log.info("회원가입 포스트");
        log.info(mentorRegisterDTO);
        mentorRegisterService.add(mentorRegisterDTO);

        return "redirect:/member/mentorRegister";
    }

//    @GetMapping({"/mentorRegister", "/mentorModify"})
//    public void view(int mentorNo, PageRequestDTO pageRequestDTO, Model model, HttpServletRequest request) {
//        log.info("멤버 보기");
//        String requestedUrl = request.getRequestURI();
//        log.info(requestedUrl);
//
//        MentorRegisterDTO mentorRegisterDTO = null;
//        if (requestedUrl.equals("/member/mentorRegister")) {
//            MentorRegisterDTO = MentorRegisterService.getOne(mentorNo, "mentorRegister");
//        } else {
//            MentorRegisterDTO = MentorRegisterService.getOne(mentorNo, "modify");
//        }
//
//        model.addAttribute("dto", mentorRegisterDTO);
//    }

    @PostMapping("/modify")
    public String modify(MentorRegisterDTO mentorRegisterDTO, RedirectAttributes redirectAttributes) {
        log.info("멘토 정보 수정" + mentorRegisterDTO);

        mentorRegisterService.modifyOne(mentorRegisterDTO);

        redirectAttributes.addAttribute("mentorNo", mentorRegisterDTO.getMentorNo());

        return "redirect:/main";
    }

    @PostMapping("/remove")
    public String  remove(Long mentorNo) {
        log.info("멘토 삭제");
        mentorRegisterService.removeOne(mentorNo);

        return "redirect:/main";
    }

}
