package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication: 부트 프로젝트를 시작하는 파일 
// 1. 내장된 톰캣 서버 자동시작
// run as > spring boot app

@SpringBootApplication
@ComponentScan(basePackageClasses = HelloController.class)
public class BootApplication {

	public static void main(String[] args) {
		System.out.println("=====스프링부트실행시작=====");
		SpringApplication.run(BootApplication.class, args); // 현재클래스를 실행하라 -> 내장된 톰캣서버 실행 명령
		System.out.println("=====스프링부트실행종료=====");
	}

}
