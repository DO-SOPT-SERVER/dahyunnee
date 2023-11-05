package com.server.dosopt.seminar.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass  //  다른 엔티티 클래스에서 상속하거나 포함하여 공통 속성 및 매핑 정보 공유
@EntityListeners(AuditingEntityListener.class)  // 엔티티의 변화를 감지하여 엔티티와 매핑된 테이블의 데이터를 조작
public abstract class BaseEntity {
   @CreatedDate     // LocalDateTime createdAt = LocalDateTime.now()를 해주지 않아도 됨
   private LocalDateTime createdAt;

   @LastModifiedDate
   private LocalDateTime updatedAt;
}
