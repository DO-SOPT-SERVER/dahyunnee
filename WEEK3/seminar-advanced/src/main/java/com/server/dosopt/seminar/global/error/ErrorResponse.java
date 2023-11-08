package com.server.dosopt.seminar.global.error;

import lombok.Getter;

public record ErrorResponse (
   int status,
   String code,
   String message
) {
   public static ErrorResponse of (ErrorCode errorCode) {
      return new ErrorResponse(
            errorCode.getStatus(),
            errorCode.getCode(),
            errorCode.getMessage()
      );
   }
};
