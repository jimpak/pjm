package com.example.sb02.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.sb02.dto.QCommentResponseDTO is a Querydsl Projection type for CommentResponseDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentResponseDTO extends ConstructorExpression<CommentResponseDTO> {

    private static final long serialVersionUID = 652357658L;

    public QCommentResponseDTO(com.querydsl.core.types.Expression<? extends com.example.sb02.model.Comment> comment) {
        super(CommentResponseDTO.class, new Class<?>[]{com.example.sb02.model.Comment.class}, comment);
    }

}

