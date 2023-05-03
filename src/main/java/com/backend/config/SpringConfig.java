package com.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.backend")
@EnableJpaRepositories("com.backend.repo")
@ComponentScan(basePackages = {"com.backend"})
@Configuration
public class SpringConfig extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringConfig.class, args);
    }
}
