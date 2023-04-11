package com.catalogo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration

public class SpringFoxConfig {
	
	@Bean
    public OpenAPI openApiDetails(){
        return new OpenAPI()
                .info(new Info().title("titulo random")
                        .description("descripcion random")
                        .version("v3.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("")
                        .url("https://github.com"));
    }
}