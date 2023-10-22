package com.server.dosopt.seminar.domain.Member.dto.request;

import com.server.dosopt.seminar.domain.Member.entity.SOPT;

/*
@Data
public class MemberCreateRequest {
   private String name;
   private String nickname;
   private int age;
   private SOPT sopt;
}
 */
public record MemberCreateRequest (
      String name,
      String nickname,
      int age,
      SOPT sopt
) {
   public static MemberCreateRequest of(MemberCreateRequest memberCreateRequest) {
      return new MemberCreateRequest(
            memberCreateRequest.name(),
            memberCreateRequest.nickname(),
            memberCreateRequest.age(),
            memberCreateRequest.sopt()
      );
   }
}