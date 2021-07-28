package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 采购方案&审核系统MQ
 * hjy
 */
@Configuration
@EnableRabbit
public class PurchaseOrderMQConfig {
    @Bean
    public Exchange directGetPurchaseExchange(){
        // 创建接收采购审核信息的交换机
        return ExchangeBuilder.directExchange("getPurchase.direct.exchange").durable(true).build();

    }

    @Bean
    public Queue getPurchaseQueue(){
        // 创建发送采购方案的队列
        return new Queue("getPurchase.direct.queue",true);
    }

    @Bean
    public Binding directExchangeGetPurchaseQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(getPurchaseQueue()).to(directGetPurchaseExchange()).with("getPurchase_direct_rk").noargs();
    }
}
