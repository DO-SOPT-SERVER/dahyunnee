package com.server.dosopt.seminar.global.exception.domain;

import com.server.dosopt.seminar.global.error.CustomErrorCode;
import com.server.dosopt.seminar.global.exception.BusinessException;

public class PostException extends BusinessException {
   public PostException(CustomErrorCode errorCode) {
      super(errorCode);
   }
}
