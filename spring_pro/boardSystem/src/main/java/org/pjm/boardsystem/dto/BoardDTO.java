package org.pjm.boardsystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// view에 영향을 주는 작업을 할때 DTO 사용

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int bno;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;
    private int visitcount;
    @Future
    private LocalDate postdate;
    private int replycount;
}
