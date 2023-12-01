package com.server.dosopt.seminar.global.exception.domain;

import com.server.dosopt.seminar.global.error.CustomErrorCode;
import com.server.dosopt.seminar.global.exception.BusinessException;

public class MemberException extends BusinessException {
   public MemberException(CustomErrorCode errorCode) {
      super(errorCode);
   }
}
