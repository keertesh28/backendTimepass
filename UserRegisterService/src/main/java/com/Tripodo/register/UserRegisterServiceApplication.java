package com.Tripodo.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@EnableDiscoveryClient*/
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.Tripodo.dataaccess")
@Configuration
@ComponentScan({"com.Tripodo.service","com.Tripodo.dataaccess","com.Tripodo.register"})
@EntityScan("com.Tripodo.entity")
public class UserRegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegisterServiceApplication.class, args);
	}

}

