package com.mateo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Contact CONTACT = new Contact(
			"Test para connect mysql", null, "mateozumelzu@hotmail.com");
		
	@Value("${info.app.name}")
	private String name;
	@Value("${info.app.version}")
	private String version;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(this.name).contact(CONTACT)
				.version(this.version).build();
	}
	
    @Bean
    public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.pathMapping("").select().paths(multiplePaths()).build();                                       
    }
    
	private Predicate<String> multiplePaths() {
		return or(regex("/prueba.*"));
	}
	

}
