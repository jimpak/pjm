package com.example.sb02.repository;

import com.example.sb02.dto.CommentResponseDTO;
import com.example.sb02.model.Comment;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentResponseDTO> findCommentByBoardId(Long boardId);
    void updateLeftRight(Comment newComment);
}
