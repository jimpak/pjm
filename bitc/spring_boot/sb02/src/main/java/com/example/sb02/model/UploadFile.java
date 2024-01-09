package com.example.sb02.model;


import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    private String uuid;
    private String filename;
    private boolean image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bno")
    private Board board;
}

