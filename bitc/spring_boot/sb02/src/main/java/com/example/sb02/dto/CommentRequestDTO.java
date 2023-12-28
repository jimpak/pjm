package com.example.sb02.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CommentRequestDTO {
    private Long id;
    private String content;
    private String writer;
    private Long boardId;
    private Long parentId;

    @Builder
    public CommentRequestDTO(String content, String writer, Long boardId, Long parentId) {
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
        this.parentId = parentId;
    }
}
