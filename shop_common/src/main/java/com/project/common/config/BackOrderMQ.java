package com.project.common.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BackOrderMQ {


    @Bean
    public Exchange directBackOrderExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("backOrder.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directBackOrderQueue(){
        //创建消息队列
        return new Queue("backOrder.direct.queue");
    }

    @Bean
    public Binding directBackOrderExchangeQueueBinding(){
        return BindingBuilder.bind(directBackOrderQueue()).to(directBackOrderExchange()).with("backOrder_direct_rk").noargs();
    }

}
