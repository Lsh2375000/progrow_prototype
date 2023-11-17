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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


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
        PageResponseDTO pageResponseDTO = boardService.list(pageRequestDTO);
        log.info(pageResponseDTO);

        model.addAttribute("responseDTO", pageResponseDTO);

        List<BoardDTO> boardDTOList = boardService.getAll();
        model.addAttribute("boardDTOList", boardDTOList);
    }


    @GetMapping("/board")
    public void add(){
        log.info("/board/add...");
    }

    @PostMapping("/add")
    public String addPost(BoardDTO boardDTO, HttpServletRequest request){
        log.info("/board/add POST...");
        log.info(boardDTO);
        boardService.add(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/register")
    public void register(){
        log.info("/board/register...HI");
    }

    /*read 페이지로 이동*/
    @GetMapping("/read")
    public void read(Long boardNo, PageRequestDTO pageRequestDTO, Model model){
        log.info("boardNo " + boardNo );
        BoardDTO boardDTO = boardService.selectOne(boardNo);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }






    @PostMapping("/delete")
    public String remove(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        Long boardNo = boardDTO.getBoardNo();
        log.info("remove post" + boardNo);

        boardService.delete(boardNo);
        log.info(boardDTO.getBoardNo());
        return "redirect:/board/list";
    }






}
