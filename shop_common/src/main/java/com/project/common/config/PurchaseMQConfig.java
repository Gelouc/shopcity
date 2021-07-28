package com.project.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 采购方案，投标相关MQ
 * yang
 */
@Configuration
@EnableRabbit
public class PurchaseMQConfig {

    @Bean
    public Exchange directQuotationExchange(){
        // 创建投标信息的交换机
        return ExchangeBuilder.directExchange("qu.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue quotationQueue(){
        // 创建投标的队列
        return new Queue("qu.direct.queue",true);
    }


    @Bean
    public Binding directExchangeQuotationQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(quotationQueue()).to(directQuotationExchange()).with("qu_direct_rk").noargs();
    }

    @Bean
    public Queue schemeQueue(){
        // 创建投标的队列
        return new Queue("scheme.direct.queue",true);
    }


    @Bean
    public Binding directExchangeSchemeQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(schemeQueue()).to(directQuotationExchange()).with("scheme_direct_rk").noargs();
    }

}
