package com.lovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(getParameterList());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("学生管理系统API文档")
                .description("这是一份关于学生管理系统的接口文档")
                .version("1.0")
                .build();
    }

    /**
     * 添加header参数
     * @return
     */
    private List getParameterList(){
        ParameterBuilder tokenParam = new ParameterBuilder();
        List params = new ArrayList();
        tokenParam.name("token").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        params.add(tokenParam.build());
        return params;

    }
}
