package com.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableConfigurationProperties(DbSettings.class)
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class, args);
	}

}
