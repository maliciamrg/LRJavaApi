package com.maliciamrg.lrcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.maliciamrg.lrcat.repository")
@EntityScan(basePackages = "com.maliciamrg.lrcat.model")
public class LrcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(LrcatApplication.class, args);
	}
}
