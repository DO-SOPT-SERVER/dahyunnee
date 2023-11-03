package com.server.dosopt.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

   HEALTH_CHECK_SUCCESS(200, "OK", true)

   ;

   private final int code;
   private final String status;
   private final Boolean success;

}
