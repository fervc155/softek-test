package com.example.villanuevac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.example.villanuevac")
public class VillanuevacApplication {

   public static void main( String[] args ) {
      SpringApplication.run(VillanuevacApplication.class, args);
   }

}
