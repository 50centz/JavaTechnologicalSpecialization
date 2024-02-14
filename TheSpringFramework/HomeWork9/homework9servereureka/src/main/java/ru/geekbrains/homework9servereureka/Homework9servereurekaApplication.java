package ru.geekbrains.homework9servereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Homework9servereurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Homework9servereurekaApplication.class, args);
	}

}
