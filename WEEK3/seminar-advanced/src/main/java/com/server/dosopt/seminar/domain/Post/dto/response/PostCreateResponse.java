package com.server.dosopt.seminar.domain.Post.dto.response;

import java.net.URI;

public record PostCreateResponse(
      URI uri
) {
   public static PostCreateResponse of(String createdPostId) {
      return new PostCreateResponse(
            URI.create("/api/posts/" + createdPostId)
      );
   };
}
