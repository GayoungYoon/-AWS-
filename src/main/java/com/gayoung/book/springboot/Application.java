package com.gayoung.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Jpa auditing 활성화
@SpringBootApplication //여기서부터 스프링 부트의 설정을 읽어감. 프로젝트 최상단에 위치해야 한다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // 내부WAS로 실행.
    }
}
