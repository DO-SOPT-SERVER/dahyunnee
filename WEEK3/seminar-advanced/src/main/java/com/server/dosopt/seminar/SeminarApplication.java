package com.server.dosopt.seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class SeminarApplication extends SpringBootServletInitializer {

   public static void main(String[] args) {
      ApplicationContext ctx = SpringApplication.run(SeminarApplication.class, args);
      DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
      dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
   }

}
