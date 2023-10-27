package com.example.springbootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
public class SpringbootActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActivemqApplication.class, args);
	}

}
