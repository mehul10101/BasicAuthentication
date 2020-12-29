package com.mehul.basicAuthentication;

import com.mehul.basicAuthentication.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BasicAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthenticationApplication.class, args);
	}

}
