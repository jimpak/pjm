package com.pjm.projectsns.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"comment\"")
public class Comment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String comment;

    public static Comment of(User user, Post post, String comment) {
        Comment entity = new Comment();
        entity.setUser(user);
        entity.setPost(post);
        entity.setComment(comment);
        return entity;
    }
}