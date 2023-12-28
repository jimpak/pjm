package com.example.sb02.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardListReplyCountDTO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Long visitcount;
    private LocalDateTime regDate;
    private Long replycount;

}
