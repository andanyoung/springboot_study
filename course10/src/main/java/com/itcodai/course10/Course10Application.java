package com.itcodai.course10;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcodai.course10.dao")
public class Course10Application {

	public static void main(String[] args) {
		SpringApplication.run(Course10Application.class, args);
	}
}
