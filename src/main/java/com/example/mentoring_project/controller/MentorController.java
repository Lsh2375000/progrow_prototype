package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MentoringDTO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.service.MentoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/mentor")
@Log4j2
@RequiredArgsConstructor
public class MentorController {
    private final MentoringService mentoringService;

    @GetMapping("/register")
    public void register() {
        log.info("/mentor/register");
    }

    @PostMapping("/register")
    public String registerPost(MentoringDTO mentoringDTO, HttpServletRequest request) {
        log.info("/mentor/register post...");

        mentoringService.add(mentoringDTO);
        return "redirect:/mentor/list";
    }

    @GetMapping("/main")
    public void mentorMain(Model model) {

    }

    @GetMapping("/list")
    public void mentorList(@Valid PageRequestDTO pageRequestDTO, Long mNo, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) { // @Valid 를 이용해서 잘못된 파라미터 값들이 들어오면 page는 1, size는 10으로 고정된 값을 처리
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        PageResponseDTO pageResponseDTO = mentoringService.getList(pageRequestDTO);
        log.info(pageResponseDTO);
//        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", pageResponseDTO); // html 파일에서 responseDTO. 으로 받아옴
        // html 파일에서
//        <tr th:each="dto:${DTOList}">
//        <td>[[${dto.bno}]]</td>

    }

    @GetMapping("/list/{mNo}")
    public void view(@PathVariable("mNo") Long mNo) throws Exception{
        // 모달창 클릭시 getOne()
//        MentoringDTO mentoringDTO = mentoringService.getOne(mNo);
//        log.info("mentoringDTO..."+mentoringDTO);
//        model.addAttribute("dto2", mentoringDTO);

    }



}
