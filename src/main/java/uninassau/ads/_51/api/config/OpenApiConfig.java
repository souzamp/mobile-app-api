package uninassau.ads._51.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API Responsável por integrar o app da disciplina de Desenvolvimento para Dispositivos Móvel - ADS")
                        .description(
                                "Projeto criado com Spring 3, JDK 17 e database H2.")
                        .contact(new Contact().name("Marcos Souza").url("https://github.com/souzamp")));
    }
}