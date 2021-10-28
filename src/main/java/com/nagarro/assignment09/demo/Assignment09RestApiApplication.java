package com.nagarro.assignment09.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nagarro.entity_class.Authors;
import com.nagarro.entity_class.Books;

@SpringBootApplication
@EntityScan(basePackageClasses = {Books.class,Authors.class})
@EnableJpaRepositories("com.nagarro.assignment09.repository")
@ComponentScan({"com.nagarro.assignment09.controllers"})
public class Assignment09RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment09RestApiApplication.class, args);
	}

}
