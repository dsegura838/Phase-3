package com.example.SpringSecurity.MySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.SpringSecurity.MySpringSecurity.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MySpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurityApplication.class, args);
	}

}
