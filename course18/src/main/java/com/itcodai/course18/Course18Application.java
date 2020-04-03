package com.itcodai.course18;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot启动类
 * @author shengwu ni
 */
@SpringBootApplication
@MapperScan("com.itcodai.course18.dao")
public class Course18Application {

	public static void main(String[] args) {
		SpringApplication.run(Course18Application.class, args);
	}
}
