package com.bookworld.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class MyConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	// Configuración CORS para permitir acceso desde Angular frontend en localhost:4200
	// CORS configuration to allow the access from an Angular frontend. 

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				/* More code here./ Más código aquí */
				
				registry.addMapping("/book/search/**")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("GET", "POST", "OPTIONS")
					.allowedHeaders("*")   // Permite todos los headers
					.allowCredentials(true) 
					.maxAge(3600);
			}
			
		};
	}
}
