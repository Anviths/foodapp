package com.ty.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class FoodAppConfig {
	@Bean(value = "entityManagerFactory")
	
	public EntityManagerFactory entityManager() {
		return Persistence.createEntityManagerFactory("java");
	}
}
