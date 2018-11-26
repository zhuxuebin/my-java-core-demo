package com.zxb.java.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zxb.java.core.mapstruct")
public class MySpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootDemoApplication.class, args);
	}
}
