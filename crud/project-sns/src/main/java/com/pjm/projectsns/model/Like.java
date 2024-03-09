package com.pjm.projectsns.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"like\"")
public class Like extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public static Like of(User user, Post post) {
        Like entity = new Like();
        entity.setUser(user);
        entity.setPost(post);
        return entity;
    }
}
