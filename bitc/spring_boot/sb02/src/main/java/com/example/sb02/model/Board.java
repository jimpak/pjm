package com.example.sb02.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(nullable = false, length = 200)
    private String title;
    @Lob
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, length = 45)
    private String writer;
    @ColumnDefault("0")
    private int visitcount;
//    @ManyToOne(fetch = FetchType.LAZY) //fetch lazy는 명시적으로 자료를 부를때만 가져오고, eager의 경우는 무조건 불러온다.
//    @JoinColumn(name="user_id")
//    private Member member;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "reply")
//    private List<Reply> replyList;
    //양방향 매핑을 하게되면 서로가 정보를 불러오는 무한루프가 발생될 수 있다. 그래서 잘 안씀
//    private Long replycount; //동적쿼리 쓰지 않을 때 넣는 reply 정보
//    public void updateReplycount(){this.replycount++;}

    public void change(String title, String content, String writer){
        this.title=title;
        this.content=content;
        this.writer=writer;
    }
    public void updateVisitcount(){
        this.visitcount++;
    }


}
