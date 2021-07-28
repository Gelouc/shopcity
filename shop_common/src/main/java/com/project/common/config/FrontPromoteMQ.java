package com.project.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class FrontPromoteMQ {
    @Bean
    public Exchange directFrontPromoteExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("frontPromote.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directFrontPromoteQueue(){
        //创建消息队列
        return new Queue("frontPromote.direct.queue");
    }

    @Bean
    public Binding directFrontPromoteExchangeQueueBinding(){
        return BindingBuilder.bind(directFrontPromoteQueue()).to(directFrontPromoteExchange()).with("frontPromote_direct_rk").noargs();
    }
}
