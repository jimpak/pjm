package com.pjm.projectsns.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(length = 255)
    private String userName;

    @Column(unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    public static User of(String userName, String encodedPwd) {
        User entity = new User();
        entity.setUserName(userName);
        entity.setPassword(encodedPwd);
        return entity;
    }
}
