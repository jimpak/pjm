package com.example.sb02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data @Entity
public class Member {
    @Id
    private String username;
    private String password;
    private String phone;
}
