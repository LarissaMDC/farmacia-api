package com.farmacia.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI farmaciaOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Servidor de Desenvolvimento");

        Server prodServer = new Server();
        prodServer.setUrl("https://api.farmacia.com");
        prodServer.setDescription("Servidor de Produção");

        Contact contact = new Contact();
        contact.setEmail("contato@farmacia.com");
        contact.setName("Equipe Farmácia API");
        contact.setUrl("https://www.farmacia.com");

        License mitLicense = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("Farmácia API")
                .version("1.0.0")
                .contact(contact)
                .description("API RESTful para gestão de medicamentos em farmácia")
                .termsOfService("https://www.farmacia.com/terms")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}