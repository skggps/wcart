package com.wissen.wcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class WcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcartApplication.class, args);
	}

	// To access swagger UI -> http://localhost:7070/wcart/swagger-ui.html
	// Create Docket Bean to configure Swagger2 for your Spring Boot application. 
	// We need to define the base package to configure REST API(s) for Swagger2

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.wissen.wcart")).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("W-Cart")
				.description("A simple e-commerce platform")
				.version("1.0.0").build();
	}
	
	

}