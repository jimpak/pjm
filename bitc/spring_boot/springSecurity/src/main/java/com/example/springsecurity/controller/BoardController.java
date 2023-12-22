package com.example.springsecurity.controller;

import com.example.springsecurity.config.auth.PrincipalDetails;
import com.example.springsecurity.domain.Board;
import com.example.springsecurity.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/register")
    public void register() {}

    @PostMapping("/register")
    public String register(Board board, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        boardService.insert(board, principalDetails.getUser());
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", boardService.list());
    }

    @GetMapping({"/view", "modify"})
    public void get(@RequestParam Long num, Model model) {
        model.addAttribute("board", boardService.getBoard(num));
    }

    @PostMapping("/modify")
    public String modify(Board board) {
        boardService.modify(board);
        return "redirect:/board/view?num=" + board.getNum();
    }

    @GetMapping("/remove")
    public String remove(Long num) {
        boardService.remove(num);
        return "redirect:/board/list";
    }

}
