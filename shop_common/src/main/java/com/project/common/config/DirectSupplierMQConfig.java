package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class DirectSupplierMQConfig {
    @Bean
    public Exchange directSupplierRegisterExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("direct.supplier.register.exchange").durable(true).build();
    }

    @Bean
    public Queue directRestryQueue(){
        return new Queue("direct.supplier.register.queue");
    }

    @Bean
    public Queue directRegisterResultQueue(){
        //创建消息队列--负责接收是审核端的消息
        return new Queue("direct.supplier.register.result.queue");
    }



    @Bean
    public Binding directResultBinding(){
        return BindingBuilder.bind(directRegisterResultQueue()).to(directSupplierRegisterExchange()).with("result_rk").noargs();
    }


    @Bean
    public Binding directRegistryBinding(){
        return BindingBuilder.bind(directRestryQueue()).to(directSupplierRegisterExchange()).with("direct.supplier.register.queue").noargs();
    }





}
