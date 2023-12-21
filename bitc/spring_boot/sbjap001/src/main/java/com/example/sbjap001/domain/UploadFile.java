package com.example.sbjap001.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long fno;
    private String filename;
    private String uuid;
    private boolean image;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "bno") private Board board;
}
