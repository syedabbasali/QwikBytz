package com.qwikbytz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.qwikbytz.repositories")
class QwikBytzApplication {
	public static void main(String[] args) {
		SpringApplication.run(QwikBytzApplication.class, args);
	}
}
