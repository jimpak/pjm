package com.example.sp_jpa01.service;

import com.example.sp_jpa01.model.Board;

import java.util.List;

public interface BoardService {
    Board register(Board board);
    List<Board> getList();
    Board getBoard(Long bno);
    Board modify(Board board);
    void remove(Long bno);
}
