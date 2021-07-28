package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class PurchaseBackMQConfig {
    @Bean
    public Exchange directBackPurchaseExchange(){

        return ExchangeBuilder.directExchange("bp.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue backPurchaseQueue(){
        // 创建接收审核信息的队列
        return new Queue("bp.direct.queue",true);
    }


    @Bean
    public Binding directExchangeBackPurchaseQueueBinding(){
        // 将交换机和审核信息队列绑定
        return BindingBuilder.bind(backPurchaseQueue()).to(directBackPurchaseExchange()).with("bp_direct_rk").noargs();
    }

    @Bean
    public Queue orderQueue(){
        // 创建订单信息的队列
        return new Queue("order.direct.queue",true);
    }


    @Bean
    public Binding directExchangeSchemeQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(orderQueue()).to(directBackPurchaseExchange()).with("order_direct_rk").noargs();
    }
}
