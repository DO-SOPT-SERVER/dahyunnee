package com.server.dosopt.seminar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HealthCheckResponse {

   private static final String STATUS = "OK";
   private String status;

   public HealthCheckResponse() {
      this.status = STATUS;
   }

}
