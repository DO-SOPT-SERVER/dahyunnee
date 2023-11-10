package com.server.dosopt.seminar.global.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum CustomErrorCode {
   // MEMBER
   MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다."),

   // POST
   POST_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 게시글입니다."),

   ;

   private final HttpStatus status;
   private final String message;
}
