package com.pjm.app08_myboard.controller;

import com.pjm.app08_myboard.dto.Board;
import com.pjm.app08_myboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/insert")
    public Board insert(@RequestBody Board board) {
        boardService.insert(board);
        return board;
    }

    @GetMapping("/list")
    public List<Board> getBoardList() {
        return boardService.getList();
    }

    @DeleteMapping("/delete/{num}")
    public void deleteBoard(@PathVariable Long num) {
        boardService.delete(num);
    }
}
