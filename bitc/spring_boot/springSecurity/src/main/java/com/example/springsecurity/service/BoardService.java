package com.example.springsecurity.service;

import com.example.springsecurity.domain.Board;
import com.example.springsecurity.domain.User;

import java.util.List;

public interface BoardService {
    void insert(Board board, User user);
    public List<Board> list();
    Board getBoard(Long bno);
    void modify(Board board);
    void remove(Long bno);
}
