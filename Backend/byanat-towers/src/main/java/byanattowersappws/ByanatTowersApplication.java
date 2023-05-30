package byanattowersappws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;



//http://localhost:8080/swagger-ui/index.html

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title = "Byanat APIs", version = "3"),
		servers = {@Server(url = "http://localhost:8080"), @Server(url = "https://www.byanat.om")},
		tags = {@Tag(name = "Towers APIs", description = "Main apis operation")}
		)
@SecurityScheme(name = "BearerJWT", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT",
 description = "BBeare token for the project")
public class ByanatTowersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByanatTowersApplication.class, args);
	}
	

}
