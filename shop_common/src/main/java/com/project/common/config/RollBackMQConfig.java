package com.project.common.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RollBackMQConfig {
    @Bean
    public Exchange directSupplierExchange(){
        //创建退货交换机退货
        return ExchangeBuilder.directExchange("direct.rollBack.register.exchange").durable(true).build();
    }
    @Bean
    public Queue directRegisterQueue(){
        //创建退货消息队列
        return new Queue("direct.rollBack.register.queue");
    }
    @Bean
    public Binding directSupplierExchangeQueueBinding(){
        return BindingBuilder.bind(directRegisterQueue()).to(directSupplierExchange()).with("direct_rollBack_register_rk").noargs();
    }
}
