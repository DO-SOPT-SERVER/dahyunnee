package com.server.dosopt.seminar.dto;

import lombok.Getter;


@Getter
public class ResultResponse {

   private int code;
   private String status;
   private Boolean success;
   private Object data;

   public static ResultResponse of(ResultCode resultCode, Object data) {
      return new ResultResponse(resultCode, data);
   }

   public static ResultResponse of(ResultCode resultCode) {
      return new ResultResponse(resultCode);
   }

   public ResultResponse(ResultCode resultCode, Object data) {
      this.code = resultCode.getCode();
      this.status = resultCode.getStatus();
      this.success = resultCode.getSuccess();
      this.data= data;
   }

   public ResultResponse(ResultCode resultCode) {
      this.code = resultCode.getCode();
      this.status = resultCode.getStatus();
      this.success = resultCode.getSuccess();
   }

}