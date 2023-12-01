package com.server.dosopt.seminar.domain.Member.dto.request;

import com.server.dosopt.seminar.domain.Member.entity.Part;


/*
@Data
public class MemberProfileUpdateRequest {
   private int generation;
   private Part part;
}
 */
public record MemberProfileUpdateRequest<part>(
   int generation,

   Part part
) {

   public static MemberProfileUpdateRequest of (int generation, Part part) {
      return new MemberProfileUpdateRequest(
            generation,
            part
      );
   }
};
