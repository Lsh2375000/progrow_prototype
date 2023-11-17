package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MentoringDTO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.service.MentoringService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping({"/mentoring", "/"})
@Log4j2
@RequiredArgsConstructor
public class MentoringController {
    private final MentoringService mentoringService;

    @GetMapping("/")
    public String mainBa(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<MentoringDTO> responseDTO = mentoringService.getList(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);

        return "/mentoring/main";
    }

    @GetMapping("/register")
    public void register() {
        log.info("/mentoring/register");
    }

    @PostMapping("/register")
    public String registerPost(MentoringDTO mentoringDTO, HttpServletRequest request) {
        log.info("/mentoring/register post...");

        mentoringService.add(mentoringDTO);
        return "redirect:/mentoring/list";
    }

    @GetMapping("/main")
    public void mentorMain(@Valid PageRequestDTO pageRequestDTO, Long mNo, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) { // @Valid 를 이용해서 잘못된 파라미터 값들이 들어오면 page는 1, size는 10으로 고정된 값을 처리
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        PageResponseDTO pageResponseDTO = mentoringService.getList(pageRequestDTO);
        log.info(pageResponseDTO);
//        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", pageResponseDTO); // html 파일에서 responseDTO. 으로 받아옴
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

    @GetMapping("/recruit")
    public void recruit(Long mNo, Model model) {
        MentoringDTO mentoringDTO = mentoringService.getOne(mNo);
        log.info("/mentoring/recruit");

        model.addAttribute("dto2", mentoringDTO); // dto라는 이름으로 html 파일에서 사용하게끔
    }

//    @ResponseBody // RestController 방식(반환 값으로 뷰를 찾지 않고, HTTP 메세지 바디에 바로 입력)
//    @GetMapping("/list/{mNo}") // JSON 방식으로 처리하는 어노테이션
//    public MentoringDTO getMentoringDTO(@PathVariable("mNo") Long mNo) throws Exception{
//        // 모달창 클릭시 getOne()
//        MentoringDTO mentoringDTO = mentoringService.getOne(mNo);
//        log.info("mentoringDTO..."+mentoringDTO);
//
//        return mentoringDTO;
////        model.addAttribute("dto2", mentoringDTO);
//    }

   /* @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public String mentorList(@Valid PageRequestDTO pageRequestDTO, HttpServletRequest request, Long mNo, BindingResult bindingResult, Model model) {
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

        CommentBean result = new CommentBean();
        result.setEMAIL(paramMap.get("email").toString());
        result.setPOST_NUM(paramMap.get("post_num").toString());
        result.setCONTENT(paramMap.get("content").toString());

        String requestedUrl = request.getRequestURI();
        MentoringDTO mentoringDTO = null;
        mentoringDTO = mentoringService.getOne(mNo);

        log.info("mentoringDTO: " + mentoringDTO);
        model.addAttribute("dto2", mentoringDTO);
        return "/list :: #commentTable";
    }*/



//    @ApiOperation(value = "Read Reply", notes = "Get 방식으로 특정 댓글 조회")
//    @GetMapping(value = "/{rno}")
//    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno) {
//        ReplyDTO replyDTO = replyService.read(rno);
//        return replyDTO;
//    }


//    @RequestMapping(value = "/view", method = {RequestMethod.POST})
//    public String view(Long mNo, Model model, HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
//
//        log.info("/board/view");
//        String requestedUrl = request.getRequestURI();
//        log.info("requestedUrl: " + requestedUrl);
//
//        MentoringDTO mentoringDTO = null;
//        mentoringDTO = mentoringService.getOne(mNo);
////        if(requestedUrl.equals("/board/view")) {
////            boardDTO=boardService.getOne(bno, "view");
////        } else {
////            boardDTO=boardService.getOne(bno, "modify");
////        }
//
//        log.info("mentoringDTO: " + mentoringDTO);
//        model.addAttribute("dto", mentoringDTO);
//
//        return "/view :: #commentTable";
//    }
}
