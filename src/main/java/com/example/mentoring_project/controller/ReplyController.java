package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.ReplyDTO;
import com.example.mentoring_project.service.ReplyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
    private final  ReplyService replyService;
    @ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {
        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }
        Map<String, Long> resultmap = new HashMap<>();
        Long rno = replyService.insertReply(replyDTO);
        resultmap.put("rno", 10L);

        return resultmap;
    }

    @ApiOperation(value = "Relies of Board", notes = "GET 방식으로 특정 게시물 댓글 목록")
    @GetMapping(value = "/list/{boardNo}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("boardNo") Long boardNo, PageRequestDTO pageRequestDTO){
        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(boardNo, pageRequestDTO);
        return  responseDTO;
    }

    @ApiOperation(value = "Read Reply", notes = "GET 방식으로 특정 댓글 조회")
    @GetMapping(value = "/{boardNo}")
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno){
        ReplyDTO replyDTO = replyService.read(rno);
        return replyDTO;
    }

    @PostMapping("/insert")
    public String insertReply(ReplyDTO replyDTO, HttpServletRequest request){
        log.info("/reply/addReply Post...");
        log.info(replyDTO);
        replyService.insertReply(replyDTO);
        return "redirect:/board/read";
    }


}
