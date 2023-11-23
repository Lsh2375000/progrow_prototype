package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, Long boardNo, BindingResult bindingResult, Model model){
        log.info("/board/list...");
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.getList(pageRequestDTO);
        log.info(pageResponseDTO);

        model.addAttribute("responseDTO", pageResponseDTO);

    }


    @GetMapping("/register")
    public void registerGet(){
        log.info("/board/register...HI");
    }

    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("board POST register...");

        if (bindingResult.hasErrors()){
            log.info("has error....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/board/register";
        }

        log.info(boardDTO);
        Long boardNo = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("result", boardNo);
        return "redirect:/board/list";

    }

    /*read, modify 페이지로 이동*/
    @GetMapping({"/read", "/modify"})
    public void read(Long boardNo, PageRequestDTO pageRequestDTO, Model model){
        log.info("boardNo " + boardNo );
        BoardDTO boardDTO = boardService.selectOne(boardNo);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid BoardDTO boardDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        log.info("board modify post......" + boardDTO);

        if(bindingResult.hasErrors()){
            log.info("has errors....");

            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("boardNo", boardDTO.getBoardNo());
            return "redirect:/board/modify? + link";
        }
        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("boardNo", boardDTO.getBoardNo());

        return "redirect:/board/read";

    }

    @PostMapping("/delete")
    public String removeOne(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        Long boardNo = boardDTO.getBoardNo();
        log.info("remove post" + boardNo);

        boardService.deleteOne(boardNo);
        log.info(boardDTO.getBoardNo());
        return "redirect:/board/list";
    }









}
