package com.ni.retail;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = { "com.ni.retail.services", "com.ni.retail.repositries",
      "com.ni.retail.config","com.ni.retail.controllers" })
@EnableJpaRepositories
@SpringBootApplication
public class RetailerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


   
}
