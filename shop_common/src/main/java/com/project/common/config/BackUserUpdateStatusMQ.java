package com.project.common.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BackUserUpdateStatusMQ {

    @Bean
    public Exchange directBackUserUpdateStatusExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("backUserUpdateStatus.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directBackUserUpdateStatusQueue(){
        //创建消息队列
        return new Queue("backUserUpdateStatus.direct.queue");
    }

    @Bean
    public Binding directBackUserUpdateStatusExchangeQueueBinding(){
        return BindingBuilder.bind(directBackUserUpdateStatusQueue()).to(directBackUserUpdateStatusExchange()).with("backUserUpdateStatus_direct_rk").noargs();
    }
}
