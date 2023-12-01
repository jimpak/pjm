package org.pjm.boardsystem.controller;

import lombok.extern.log4j.Log4j2;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        List<BoardDTO> boardDTOS = boardService.getList();
        model.addAttribute("boardList", boardDTOS);
    }
}
