package com.project.luckybocky.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass   //테이블로 만들어 지지는 않지만 엔티티들의 공통속성을 상속
@EntityListeners(AuditingEntityListener.class)  //CreatedDate같이 자동으로 생성하기 위해 사용
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
