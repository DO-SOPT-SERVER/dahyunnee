package com.server.dosopt.seminar.domain.Member.dto.response;

import java.net.URI;

public record MemberCreateResponse (
      URI uri
) {
   public static MemberCreateResponse of (String createdMemberId) {
      return new MemberCreateResponse(
            URI.create("api/member/" + createdMemberId)
      );
   }
}