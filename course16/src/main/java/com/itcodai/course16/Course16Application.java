package com.itcodai.course16;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcodai.course16.dao")
public class Course16Application {

	public static void main(String[] args) {
		SpringApplication.run(Course16Application.class, args);
	}
}
