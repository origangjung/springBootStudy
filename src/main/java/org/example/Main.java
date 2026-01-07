package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // 👈 이 어노테이션을 꼭 붙여야 합니다!
public class Main {
    public static void main(String[] args) {
        // 👈 실행 코드를 스프링 부트용으로 변경
        SpringApplication.run(Main.class, args);
    }
}