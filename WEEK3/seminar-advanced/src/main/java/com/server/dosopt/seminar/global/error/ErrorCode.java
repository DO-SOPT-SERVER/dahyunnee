package com.server.dosopt.seminar.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorCode {

   MEMBER_NOT_FOUND(400, "M001","존재하지 않는 유저입니다."),
   ;

   private final int status;
   private final String code;
   private final String message;

}
