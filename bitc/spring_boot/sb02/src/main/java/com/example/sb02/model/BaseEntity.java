package com.example.sb02.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@MappedSuperclass //슈퍼클래스가 되었다.
@EntityListeners(value = {AuditingEntityListener.class})
//위의 어노테이션으로 인해 엔티티가 데이터베이스에 추가되거나 수정될 때 값이 자동으로 설정
@Data
public class BaseEntity {
    @CreatedDate @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;
    @LastModifiedDate @Column(name = "moddate")
    private LocalDateTime modDate;
}
