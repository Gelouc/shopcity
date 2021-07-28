package com.project.common.config.reviemMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableRabbit
public class AuditDepositMQConfig {
    @Bean
    public Exchange getDepositExchange(){
        //创建预存款的直连交换机
        return ExchangeBuilder.directExchange("review.direct.deposit.exchange").durable(true).build();
    }
    @Bean
    public Queue getDepositQueue(){
        //创建预存款的队列
        return  new Queue("review.deposit.queue",true);
    }
    @Bean
    public Binding getDepositBinding(){
        //创建预存款的路由键
        return BindingBuilder.bind(this.getDepositQueue()).to(this.getDepositExchange()).with("review_deposit_rk").noargs();
    }
}
