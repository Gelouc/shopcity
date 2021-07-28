package com.project.common.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 供应商订单直连模式的MQ配置
 */
@Configuration
@EnableRabbit
public class PscOrderDirectMQConfig {
    @Bean
    public Exchange directOrderExchange(){
        // 创建订单的交换机
        return ExchangeBuilder.directExchange("order.direct.exchange").durable(true).build();
    }


    @Bean
    public Queue tenderOrderQueue(){
        // 创建订单标消息的队列
        return new Queue("order.direct.queue",true);
    }


    @Bean
    public Binding directExchangeTenderQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(tenderOrderQueue()).to(directOrderExchange()).with("order_direct_rk").noargs();
    }

}
