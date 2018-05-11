package com.myspringbootapps.springDataplusValidation;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SpringDataplusValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataplusValidationApplication.class, args);
	}
	
}
