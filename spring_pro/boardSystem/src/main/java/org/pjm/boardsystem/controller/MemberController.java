package org.pjm.boardsystem.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.dto.MemberDTO;
import org.pjm.boardsystem.dto.ReplyDTO;
import org.pjm.boardsystem.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public void join() {
    }

    @PostMapping("/join")
    public String joinPost(@Valid MemberDTO memberDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info(memberDTO);
        if (bindingResult.hasErrors()) {
            log.info("error............");
            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            return "redirect:/member/login";
        }

        int result = memberService.join(memberDTO);
        log.info(result);
        if(result != 1) {
            redirectAttributes.addFlashAttribute("error", "회원 가입 실패");
            return "redirect:/member/join";
        }
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public void login() {
    }


//    @PostMapping("/login")
//    public String login(MemberDTO memberDTO, HttpSession session) {
//        memberDTO = memberService.login(memberDTO.getUsername(), memberDTO.getPassword());
//        if(memberDTO != null) {
//            session.setAttribute("dto", memberDTO);
//            return "/board/list";
//        }
//        return "/member/login";
//    }

    @GetMapping("/conformUsername")
    @ResponseBody
    public ResponseEntity<String> conformUsername(@RequestParam("username") String username) {
        boolean result = memberService.conformUsername(username);
        String str = null;
        if(result) {
            str = username + "은 중복됩니다.";
        } else {
            str = username + "은 사용가능합니다";
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}
