package com.server.dosopt.seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// @EnableJpaAuditing
public class SeminarApplication {

   public static void main(String[] args) {
      SpringApplication.run(SeminarApplication.class, args);
   }

}
