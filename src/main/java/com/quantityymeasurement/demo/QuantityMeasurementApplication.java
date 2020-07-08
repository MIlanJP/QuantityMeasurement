package com.quantityymeasurement.demo;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class QuantityMeasurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuantityMeasurementApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/quantitymeasurement/*")).
                apis(RequestHandlerSelectors.basePackage("com.quantityymeasurement.demo")).build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
            return new ApiInfo(
                    "Quantity Measurement",
                    "Quantity Measurement API is about you can use it convert any units and add any units",
                    "1",
                    "Terms",
                    new Contact("Milan", "http://localhost:8080/quantitymeasurement", "milan@gmail.com"),
                    "License of API", "API license URL", Collections.emptyList());
    }


}
