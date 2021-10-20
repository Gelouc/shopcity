package com.lovo.config;

import com.lovo.intercepter.JWTInterceptor;
import com.lovo.intercepter.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
//    private MyInterceptor myInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:d:/BaiduYunDownload/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
//        registry.addInterceptor(jwtInterceptor()) //添加需要验证登录用户操作权限的请求
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**");  //这里可以用registry.addInterceptor添加多个拦截器实例，后面加上匹配模式
//        super.addInterceptors(registry);//最后将register往这里塞进去就可以了
//    }
//
//    @Bean
//    public JWTInterceptor jwtInterceptor(){
//        return new JWTInterceptor();
//    }
}
