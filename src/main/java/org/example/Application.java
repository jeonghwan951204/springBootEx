package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing      //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 스프링부트의 내장 WAS를 사용
        SpringApplication.run(Application.class,args);
    }
}
