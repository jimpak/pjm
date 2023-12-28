package com.example.sb02.service;

import com.example.sb02.dto.CommentRequestDTO;
import com.example.sb02.dto.CommentResponseDTO;
import com.example.sb02.model.Comment;

import java.util.List;

public interface CommentService {
    void create (CommentRequestDTO commentRequestDTO);
    void delete (Long cno);
    List<CommentResponseDTO> findAll(Long boardId);
}
