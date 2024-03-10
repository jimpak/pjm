package com.pjm.projectsns.dto;

import com.pjm.projectsns.model.Comment;
import com.pjm.projectsns.model.Like;
import com.pjm.projectsns.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Setter
@Getter
@ToString
@Log4j2
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    private User user;

    private List<Comment> comments;

    private List<Like> likes;

}
