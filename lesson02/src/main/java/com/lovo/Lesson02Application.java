package com.lovo;

import com.lovo.intercepter.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Lesson02Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Lesson02Application.class, args);
    }


}
