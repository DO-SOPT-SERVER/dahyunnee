package com.server.dosopt.seminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")
public class Post extends BaseEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String title;

   @Column(columnDefinition = "TEXT")  // 컬럼정보 직접 설정. varChar로 설정 안하기 위해
   private String content;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "member_id")
   private Member member;

   @Builder
   public Post(String title, String content, Member member) {
      this.title = title;
      this.content = content;
      this.member = member;
   }

   public void updateContent(String content) { this.content = content; }
}
