package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.**.controller", "com.**.service", "com.**.entity", "com.example.demo"})
public class MybatisPlusDemoApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(MybatisPlusDemoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusDemoApplication.class, args);
	}

}
