package com.server.dosopt.seminar.domain.Member.dto.response;

import com.server.dosopt.seminar.domain.Member.entity.Member;
import com.server.dosopt.seminar.domain.Member.entity.SOPT;

public record MemberGetResponse (
   String name,
   String nickname,
   int age,
   SOPT soptInfo
) {
   public static MemberGetResponse of (Member member) {
      return new MemberGetResponse(
            member.getName(),
            member.getNickname(),
            member.getAge(),
            member.getSopt()
      );
   }
}
