package com.server.dosopt.seminar.global.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ResultCode {
   HEALTH_CHECK_SUCCESS(HttpStatus.OK, "🫀Health Check 성공🫁"),

   // MEMBER 관련
   GET_MEMBER_PROFILE_SUCCESS(HttpStatus.OK, "멤버 조회 성공"),
   GET_MEMBER_LIST_PROFILE_SUCCESS(HttpStatus.OK, "멤버 목록 조회 성공"),
   CREATE_MEMBER_SUCCESS(HttpStatus.CREATED, "멤버 생성 성공"),
   UPDATE_MEMBER_SOPT_INFO_SUCCESS(HttpStatus.NO_CONTENT, "멤버 솝트 정보 변경 성공"),
   DELETE_MEMBER_SUCCESS(HttpStatus.NO_CONTENT, "멤버 삭제 성공"),

   // POST 관련
   GET_POST_SUCCESS(HttpStatus.OK, "게시글 조회 성공"),
   GET_MEMBER_POST_LIST_SUCCESS(HttpStatus.OK, "게시글 목록 조회 성공"),
   CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시글 생성 성공"),
   UPDATE_POST_SUCCESS(HttpStatus.NO_CONTENT, "게시글 수정 성공"),
   DELETE_POST_SUCCESS(HttpStatus.NO_CONTENT, "게시글 삭제 성공"),
   ;

   private final HttpStatus status;
   private final String message;
}
