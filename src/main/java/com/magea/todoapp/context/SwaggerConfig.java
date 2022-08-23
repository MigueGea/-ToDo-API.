package com.magea.todoapp.context;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                        .apis(RequestHandlerSelectors.basePackage("com.magea.todoapp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    

    private ApiInfo apiInfo() {
        String description = "La API REST de ToDO App.";
        return new ApiInfoBuilder()
                .title("Todo API")
                .description(description)
                .termsOfServiceUrl("Terms of Service")
                .license("License of API")
                .licenseUrl("API license URL")
                .version("1.0")
 //               .contact(new Contact("siamak"))
                .build();
    }

}
