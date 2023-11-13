package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.QBoardDTO;
import com.example.mentoring_project.service.BoardService;
import com.example.mentoring_project.service.QBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/qboard")
@Log4j2
@RequiredArgsConstructor
public class QBoardController {
    private final QBoardService qBoardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("/board/list...");
        List<QBoardDTO> qBoardDTOList = qBoardService.getAll();
        model.addAttribute("qBoardDTOList", qBoardDTOList);
    }


    @GetMapping("/qboard")
    public void add(){
        log.info("/board/add...");
    }

    @PostMapping("/add")
    public String addPost(QBoardDTO qBoardDTO, HttpServletRequest request){
        log.info("/qboard/add POST...");
        log.info(qBoardDTO);
        qBoardService.add(qBoardDTO);
        return "redirect:/qboard/list";
    }

    @GetMapping("/register")
    public void register(){
        log.info("/board/register...HI");
    }

    @GetMapping("read")
    public void read(Long qBoardNo){
//        QBoardDTO qboardDTO = qBoardService.
    }

    @PostMapping("/delete")
    public String remove(QBoardDTO qBoardDTO, RedirectAttributes redirectAttributes){
        Long qBoardNo = qBoardDTO.getQboardNo();
        log.info("remove post" + qBoardNo);

        qBoardService.delete(qBoardNo);
        log.info(qBoardDTO.getQboardNo());
        return "redirect:/qboard/list";
    }




}
