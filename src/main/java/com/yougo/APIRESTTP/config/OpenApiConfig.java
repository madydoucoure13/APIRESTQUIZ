package com.yougo.APIRESTTP.config;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

    @Configuration
    public class OpenApiConfig {

        @Bean
        public OpenAPI usersMicroserviceOpenAPI() {
            Contact contact = new Contact();
                    contact.setEmail("doucouremady26.md@gmail");
                    contact.setName("Mady Doucoue");
            return new OpenAPI()
                    .info(new Info().title("API REST QUIZ")
                            .description("Une API de quiz ludique")
                            .version("1.0")
                            .contact(contact));
        }
    }

