package com.example.sp_jpa01.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tbl_item") // 이 어노테이션에 설정한 이름으로 테이블 생성. 지정 안할경우 클래스명으로 생성.
public class Item {
    @Id // primary key
    @Column(name="item_id") // 칼럼명 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 숫자인 경우 무조건 Long으로 설정(int 오류발생)
    @Column(nullable = false, length = 100) // not null, varchar(100)
    private String itemName;
    @Column(name="item_price", nullable = false)
    private int price;
    @Lob // TEXT
    private String itemDetail;
    private LocalDateTime regTime;
}