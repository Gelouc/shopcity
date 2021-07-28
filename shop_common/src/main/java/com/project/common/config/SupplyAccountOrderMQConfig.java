package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 供应商供货单发送审核系统MQ
 * @author wangsj
 */
@Configuration
@EnableRabbit
public class SupplyAccountOrderMQConfig {
    @Bean
    public Exchange directSupplyAccountOrderExchange(){
        // 创建供货单发出的交换机
        return ExchangeBuilder.directExchange("supplyAccountOrder.direct.exchange").durable(true).build();
    }


    @Bean
    public Queue supplyAccountOrderQueue(){
        // 创建接收供货单消息的队列
        return new Queue("supplyAccountOrder.direct.queue",true);
    }


    @Bean
    public Binding directSupplyAccountOrderExchangeSupplyAccountOrderQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(supplyAccountOrderQueue()).to(directSupplyAccountOrderExchange()).with("supplyAccountOrder_rk").noargs();
    }
}
