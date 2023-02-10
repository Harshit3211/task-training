package com.licious.taskA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ="com.licious.taskA.repo" )
@EntityScan(basePackages = "com.licious.taskA.model")

public class TaskAApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskAApplication.class, args);
		System.out.println("Checking..");
	}

}
