package com.self.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @SpringBootApplication
 *  - 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성
 *  - 프로젝트 최상단에 위치(이 위치부터 설정을 읽음)
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run()로 내장 WAS(웹 애플리케이션 서버)를 실행
        SpringApplication.run(Application.class, args);
    }
}
