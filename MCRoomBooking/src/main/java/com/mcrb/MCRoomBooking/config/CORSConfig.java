package com.mcrb.MCRoomBooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
			.allowedMethods("GET","POST","PUT","DELETE")
			.allowedOrigins("http://localhost:4200");
		//TODO: Need to change the URL for the production URL when we deploy 
	}
	

}
