package ru.geekbrains.homework9pages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class Homework9pagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Homework9pagesApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	@Bean
//	public HttpHeaders headers()
//	{
//		return new HttpHeaders();
//	}

}
