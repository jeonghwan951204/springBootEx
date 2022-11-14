package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// spring security로 인해 controller 테스트가 안 되므로 주석 따로 분리
//@EnableJpaAuditing      //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 스프링부트의 내장 WAS를 사용
        SpringApplication.run(Application.class,args);
        
    }
}
