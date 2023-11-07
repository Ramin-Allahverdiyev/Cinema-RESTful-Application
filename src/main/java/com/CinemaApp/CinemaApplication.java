package com.CinemaApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@SecurityScheme(name = "CinemaApp",scheme = "bearer",type = SecuritySchemeType.HTTP,in = SecuritySchemeIn.HEADER,bearerFormat = "JWT")
//@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Cinema App", version ="1.0",description = "Cinema application"))
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

}
