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
public class PromoteMQ {
    @Bean
    public Exchange directPromoteExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("promote.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue directPromoterQueue(){
        //创建消息队列
        return new Queue("promote.direct.queue");
    }

    @Bean
    public Binding directPromoteExchangeQueueBinding(){
        return BindingBuilder.bind(directPromoterQueue()).to(directPromoteExchange()).with("promote_direct_rk").noargs();
    }
}
