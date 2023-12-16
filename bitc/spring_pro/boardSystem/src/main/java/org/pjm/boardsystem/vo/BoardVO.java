package org.pjm.boardsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// DB에 영향을 주는 작업을 하는 경우 VO를 사용
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private int visitcount;
    private LocalDate postdate;
    private int replycount;
}
