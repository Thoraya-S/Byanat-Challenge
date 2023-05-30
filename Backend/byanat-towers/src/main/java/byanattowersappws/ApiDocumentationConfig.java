package byanattowersappws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfig {
	
//	@Bean
//    public OpenAPI apiDocConfig() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Byanat APIs")
//                        .description("APIs for Byanat Application")
//                        .contact(new Contact()
//                                .name("Thoraya")
//                                .email("thoraya@byanat.com")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("Documentation")
//                        .url("https://www.byanat.om"));
//    }


}
