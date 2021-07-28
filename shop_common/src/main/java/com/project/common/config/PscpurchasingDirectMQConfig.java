package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

/**
 * 审核和供应商采购交换机
 */
@Configuration
@EnableRabbit
public class PscpurchasingDirectMQConfig {
    @Bean
    public Exchange directPscpurchasingExchange(){
    // 创建订单的交换机
        return ExchangeBuilder.directExchange("purchasing.direct.exchange").durable(true).build();
}


    @Bean
    public Queue tenderPscpurchasingQueue(){
        // 创建订单标消息的队列
        return new Queue("purchasing.direct.queue",true);
    }


    @Bean
    public Binding directPscpurchasingExchangeTenderQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(tenderPscpurchasingQueue()).to(directPscpurchasingExchange()).with("purchasing_direct_rk").noargs();
    }
    @Bean
    public Queue updatePscpurchasingQueue(){
        // 创建订单标消息的队列
        return new Queue("update.purchasing.direct.queue",true);
    }


    @Bean
    public Binding updatePscpurchasingExchangeTenderQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(updatePscpurchasingQueue()).to(directPscpurchasingExchange()).with("update_purchasing_direct_rk").noargs();
    }

}