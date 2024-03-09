package com.pjm.projectsns.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "\"post\"")
public class Post extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Like> likes;

    public static Post of(String title, String content, User user) {
        Post entity = new Post();
        entity.setTitle(title);
        entity.setContent(content);
        entity.setUser(user);
        return entity;
    }
}
