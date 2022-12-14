package com.mateo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching 
public class Application{    
	
	String a;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
	


	

}