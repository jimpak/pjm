package com.example.sb02.repository;

import com.example.sb02.dto.CommentResponseDTO;
import com.example.sb02.dto.QCommentResponseDTO;
import com.example.sb02.model.Comment;
import com.example.sb02.model.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    QComment comment = QComment.comment;

    @Override
    public List<CommentResponseDTO> findCommentByBoardId(Long boardId) {
        return queryFactory.select(new QCommentResponseDTO(comment))
                .from(comment)
                .where(comment.board.bno.eq(boardId))
                .orderBy(comment.root.asc(), comment.rightNum.desc(), comment.leftNum.asc())
                .fetch();
    }

    @Override
    public void updateLeftRight(Comment newComment) {
        queryFactory.update(comment)
                .set(comment.leftNum, comment.leftNum.add(2))
                .where(comment.root.eq(newComment.getRoot())
                        .and(comment.leftNum.goe(newComment.getRightNum())))
                .execute();
        queryFactory.update(comment)
                .set(comment.rightNum, comment.rightNum.add(2))
                .where(comment.root.eq(newComment.getRoot())
                        .and(comment.rightNum.goe(newComment.getLeftNum())))
                .execute();
    }


}
