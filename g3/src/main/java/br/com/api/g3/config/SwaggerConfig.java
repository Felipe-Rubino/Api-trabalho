package br.com.api.g3.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class SwaggerConfig {

	@Value("${loja.swagger.dev-url}")
	private String devUrl;
	
	@Bean
	public OpenAPI myOpenApi() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL - Ambiente de desenvolvimento");
		
		Contact contact = new Contact();
		contact.setEmail("cpnnatalie@gmail.com");
		contact.setName("Natalie");
		contact.setUrl("https://www.loja.com");
		
		License license = new License()
				.name("Apache license version 2.0")
				.url("https://www.apache.org/license/LICENSE-2.0");
		
		Info info = new Info()
				.title("Documentação API - G3")
				.version("1.0.0")
				.contact(contact)
				.termsOfService("https://www.loja.com/terms")
				.license(license);
		
		return new OpenAPI().info(info).servers(List.of(devServer));
	}
}	
