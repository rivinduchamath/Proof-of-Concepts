package com.cloudofgoods.auth.configarations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("COG_OAuth2", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .description("Oauth2 flow")
                                .flows(new OAuthFlows()
                                        .password(new OAuthFlow().tokenUrl("/api/v5/token"))
                                ))
                )
                .security(List.of(new SecurityRequirement().addList("COG_OAuth2")))
                .info(new Info()
                        .title("Cloud Of Goods oAuth2 API")
                        .description("This is Cloud of goods oAuth service api set")
                        .termsOfService("terms")
                        .contact(new Contact().email("rividuchamath@gmail.com").name("Developer: Rivindu Chamath"))
                        .license(new License().name("GNU"))
                        .version("1.0")
                );
    }
}