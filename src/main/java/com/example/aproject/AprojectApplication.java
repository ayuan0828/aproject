package com.example.aproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableAsync
@MapperScan("com.example.aproject.dao")
public class AprojectApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(AprojectApplication.class, args);
    }

    @Override
    protected  void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/")
                .addResourceLocations("classpath:/templates")
                .addResourceLocations("classpath:/static");
        super.addResourceHandlers(registry);

    }
}
