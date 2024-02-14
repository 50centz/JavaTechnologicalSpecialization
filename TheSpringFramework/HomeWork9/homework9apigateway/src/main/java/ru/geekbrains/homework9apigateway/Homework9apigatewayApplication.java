package ru.geekbrains.homework9apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Homework9apigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Homework9apigatewayApplication.class, args);
	}



	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("DataBasePcGame", r -> r.path("/**")
						.uri("http://192.168.22.69:8080/")).build();
//				.route("Microservice2", r -> r.path("/serviceB")
//						.uri("http://localhost:8081/")).build();
	}
}
