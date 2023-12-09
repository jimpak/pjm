package org.pjm.boardsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("/login")
    public String loginPro(String username, String password, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        MemberDTO dto = memberService.loginPro(username, password);
        if (dto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("member", dto);
            return "redirect:/board/list";
        }
        redirectAttributes.addFlashAttribute("msg", "로그인 실패");
        return "redirect:/member/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        // 아래 둘중 하나만 사용하면 됨.
        // 1번은 member명으로 된 세션만 삭제
        // 2번은 전체 세션 삭제
        session.removeAttribute("member");
//        session.invalidate();
        return "redirect:/board/list";
    }

    @GetMapping("/info")
    public void info() {

    }

    @GetMapping("/remove")
    public String remove(HttpServletRequest req, RedirectAttributes redirectAttributes) {
        HttpSession session = req.getSession();
        MemberDTO dto = (MemberDTO) session.getAttribute("member");
        int result = memberService.remove(dto.getUsername());
        if(result == 1) {
            session.invalidate();
            return "redirect:/board/list";
        }
        redirectAttributes.addFlashAttribute("msg", "탈퇴 실패");
        return "redirect:/member/info";
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

    @GetMapping("/conformedUsername/{username}")
    @ResponseBody
    public ResponseEntity<String> conformedUsername(@PathVariable("username") String username) {
        int result = memberService.conformUsername(username);
        String str = null;
        if(result > 0) {
            str = "fail";
        } else {
            str = "success";
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/conformedNickname/{nickname}")
    @ResponseBody
    public ResponseEntity<String> conformedNickname(@PathVariable("nickname") String nickname) {
        int result = memberService.conformUsername(nickname);
        String str = null;
        if(result > 0) {
            str = "fail";
        } else {
            str = "success";
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}
