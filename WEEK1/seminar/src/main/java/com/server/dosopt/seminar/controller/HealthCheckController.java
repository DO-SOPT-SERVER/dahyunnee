package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

   // JSON 형태로 리턴
   @GetMapping("/health")
   public Map<String, String> healthCheck() {
      Map<String, String> response = new HashMap<>();
      response.put("status", "OK");
      return response;
   }

   // String 형태로 리턴
   @GetMapping("/health2")
   public ResponseEntity<String> healthCheck2() {
      return ResponseEntity.ok("OK");
   }

   // String 형태로 리턴
   @GetMapping("/health3")
   public String healthCheck3() {
      return "OK";
   }

   @GetMapping("/health4")
   public ResponseEntity<Map<String, String>> healthCheck4() {
      Map<String, String> response = new HashMap<>();
      response.put("status", "OK");
      return ResponseEntity.ok(response);
   }

   @GetMapping("/health5")
   public ResponseEntity<HealthCheckResponse> healthCheckV5() {
      return ResponseEntity.ok(new HealthCheckResponse());
   }

}
