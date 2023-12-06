package org.pjm.boardsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyDTO {
    private int rno;
    private int bno;
    private String reply;
    private String replyer;
    private Date replydate;
}
