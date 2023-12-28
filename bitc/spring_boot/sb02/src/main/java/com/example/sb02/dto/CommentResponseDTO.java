package com.example.sb02.dto;

import com.example.sb02.model.Comment;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentResponseDTO {
    private Long id;
    private String content;
    private String writer;
    private Long boardId;
    private Long parentId;
    private List<CommentResponseDTO> children;

    @QueryProjection
    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.writer = comment.getWriter();
        this.boardId = comment.getBoard().getBno();
        if (comment.getParent() != null) {
            this.parentId = comment.getParent().getId();
        }
    }
}
