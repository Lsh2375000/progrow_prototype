package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.QBoardDTO;
import com.example.mentoring_project.service.QBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/qboard")
@Log4j2
@RequiredArgsConstructor
public class QBoardController {
    private final QBoardService qBoardService;

    @GetMapping("/list")
    public void qBoardList(@Valid PageRequestDTO pageRequestDTO, Long qBoardNo, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) { // @Valid 를 이용해서 잘못된 파라미터 값들이 들어오면 page는 1, size는 10으로 고정된 값을 처리
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        PageResponseDTO pageResponseDTO = qBoardService.getList(pageRequestDTO);
        log.info(pageResponseDTO);

        model.addAttribute("responseDTO", pageResponseDTO);
    }

    @GetMapping("/register")
    public void add(){
        log.info("/qboard/register...");
    }

    @PostMapping("/register")
    public String addPost(QBoardDTO qBoardDTO, HttpServletRequest request){
        log.info("/qboard/register POST...");
        log.info(qBoardDTO);
        qBoardService.add(qBoardDTO);
        return "redirect:/qboard/list";
    }

    @GetMapping({"/read", "modify"})
    public void view(Long qBoardNo, PageRequestDTO pageRequestDTO, Model model, HttpServletRequest request) {
        log.info("/qboard/read...");
        String requestedUrl = request.getRequestURI();
        log.info(requestedUrl);

        QBoardDTO qBoardDTO = null;
        if (requestedUrl.equals("/qboard/read")) {
            qBoardDTO = qBoardService.getOne(qBoardNo, "read");
        } else {
            qBoardDTO = qBoardService.getOne(qBoardNo, "modify");
        }

        model.addAttribute("dto", qBoardDTO);
    }

    @PostMapping("/modify")
    public String modify(QBoardDTO qBoardDTO, RedirectAttributes redirectAttributes) {
        log.info("qboard modify post....." + qBoardDTO);

        qBoardService.modify(qBoardDTO);

        redirectAttributes.addAttribute("qBoardNo", qBoardDTO.getQBoardNo());

        return "redirect:/qboard/read";
    }


    @PostMapping("/remove")
    public String remove(QBoardDTO qBoardDTO, RedirectAttributes redirectAttributes){
        Long qBoardNo = qBoardDTO.getQBoardNo();
        log.info("qBoard remove post" + qBoardNo);

        qBoardService.deleteOne(qBoardNo);
        log.info(qBoardDTO.getQBoardNo());
        return "redirect:/qboard/list";

    }






}
