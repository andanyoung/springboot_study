package com.itcodai.course11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcodai.course11.dao")
public class Course11Application {

	public static void main(String[] args) {
		SpringApplication.run(Course11Application.class, args);
	}
}
