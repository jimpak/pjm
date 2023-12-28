package com.example.sb02.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Entity
@Table(name="reply", indexes = {
        @Index(name="idx_board_bno", columnList="board_bno")
})
@Builder
@Getter @Setter @ToString(exclude = "board")
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    @ManyToOne(fetch = FetchType.LAZY) // reply(Many)에서 board(One)를 불러온다. 없으면 오류
    private Board board;
    private String replytext;
    private String replyer;

    public void changeText(String text){
        this.replytext=text;
    }
    //만약 동적쿼리를 댓글에도 넣고 싶다면?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Member member;


}
