package com.transfer.Transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.transfer"})
@EnableJpaRepositories("com.transfer")
@EntityScan("com.transfer")
public class TransportApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(TransportApplication.class, args);
	}

}

