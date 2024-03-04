package com.pjm.app07_board.controller;

import com.pjm.app07_board.model.Board;
import com.pjm.app07_board.service.BoardService;
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
        return boardService.saveBoard(board);
    }

    @GetMapping("/list")
    public List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    @DeleteMapping("/delete/{num}")
    public void deleteBoard(@PathVariable Long num) {
        boardService.deleteBoard(num);
    }

}
