package com.example.sb02.model;

import com.example.sb02.dto.CommentRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String content;
    @Column(nullable = false, length = 100)
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent; // 대댓글이 되기 위해서는 다른 테이블이 아닌 자기 테이블의 pk를 참조를 해야 한다.

    private Long root;
    private Long leftNum = 1l;
    private Long rightNum = 2l;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    @Builder
    public Comment (CommentRequestDTO commentRequestDTO){
        this.content = commentRequestDTO.getContent();
        this.writer = commentRequestDTO.getWriter();
    }
    public void setBoard(Board board){
        this.board = board;
        board.getComments().add(this);
    }

    public void setChild (Comment child) {
        child.root = this.root;
        child.parent = this;
        child.leftNum = this.leftNum +1;
        child.rightNum =child.leftNum +1;
        this.children.add(child);
    }
    public void setRootId(Comment comment){
        this.root = comment.getId();
    }
}
