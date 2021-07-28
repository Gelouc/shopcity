package com.project.common.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BackUserInfoMQ {

    @Bean
    public Exchange directBackUserInfoExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("backUserInfo.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directBackUserInfoQueue(){
        //创建消息队列
        return new Queue("backUserInfo.direct.queue");
    }

    @Bean
    public Binding directBackUserInfoExchangeQueueBinding(){
        return BindingBuilder.bind(directBackUserInfoQueue()).to(directBackUserInfoExchange()).with("backUserInfo_direct_rk").noargs();
    }

}
