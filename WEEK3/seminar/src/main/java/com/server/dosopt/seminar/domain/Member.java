package com.server.dosopt.seminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String nickname;
   private int age;

   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   private final List<Post> posts = new ArrayList<>();

   @Embedded
   private SOPT sopt;

   @Builder
   public Member(String name, String nickname, int age, SOPT sopt) {
      this.name = name;
      this.nickname = nickname;
      this.age = age;
      this.sopt = sopt;
   }

   public void updateSOPT(SOPT sopt) {
      this.sopt = sopt;
   }

}
