package com.example.springsecurity.service;

import com.example.springsecurity.domain.Board;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void insert(Board board, User user) {
        board.setUser(user);
        board.setWriter(user.getUsername());
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(Long num) {
        return boardRepository.findById(num).get();
    }

    @Override
    public void modify(Board board) {
        Board b = boardRepository.findById(board.getNum()).get();
        b.setTitle(board.getTitle());
        b.setContent(board.getContent());
        boardRepository.save(b);
    }

    @Override
    public void remove(Long num) {
        boardRepository.deleteById(num);
    }
}
