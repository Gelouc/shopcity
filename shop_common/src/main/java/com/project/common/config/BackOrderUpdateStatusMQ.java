package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BackOrderUpdateStatusMQ {


    @Bean
    public Exchange directBackOrderUpdateStatusExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("backOrderUpdateStatus.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directBackOrderUpdateStatusQueue(){
        //创建消息队列
        return new Queue("backOrderUpdateStatus.direct.queue");
    }

    @Bean
    public Binding directBackOrderUpdateStatusExchangeQueueBinding(){
        return BindingBuilder.bind(directBackOrderUpdateStatusQueue()).to(directBackOrderUpdateStatusExchange()).with("backOrderUpdateStatus_direct_rk").noargs();
    }
}
