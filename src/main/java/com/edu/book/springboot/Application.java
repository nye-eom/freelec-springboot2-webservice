package com.edu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 필수로 프로젝트 상단위치 - 스프링부트 자동설정, 스프링 bean 읽기 및 생성 자동 설정
* 어노테이션 있는 위치부터 설정을 읽어나감
* */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS 실행 - 스프링 부트로 만들어진 JAR를 톰켓설치 없이 실행
        SpringApplication.run(Application.class, args);
    }
}
