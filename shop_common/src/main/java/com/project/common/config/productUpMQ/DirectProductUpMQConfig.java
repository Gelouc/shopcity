package com.project.common.config.productUpMQ;

import com.project.common.util.MQUtil;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class DirectProductUpMQConfig {

    @Bean
    public Exchange directProductUpExchange(){
        // 创建商品上下架信息的交换机
        return ExchangeBuilder.directExchange("up.direct.exchange").durable(true).build();
    }

    @Bean
    public Queue upQueue(){
        // 创建传输商品集合消息的队列
        return new Queue("up.direct.queue",true);
    }


    @Bean
    public Binding directExchangeUpQueueBinding(){
        // 将交换机和传输消息的队列绑定
        return BindingBuilder.bind(upQueue()).to(directProductUpExchange()).with("up_direct_rk").noargs();
    }

    @Bean
    public Queue updateProductQueue(){
        // 创建修改商品状态的队列
        return new Queue("updateProduct.direct.queue",true);
    }


    @Bean
    public Binding directExchangeUpdateQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(updateProductQueue()).to(directProductUpExchange()).with("updateProduct_direct_rk").noargs();
    }

    @Bean
    public Queue delProductQueue(){
        // 创建删除商品的队列
        return new Queue("delProduct.direct.queue",true);
    }


    @Bean
    public Binding directExchangeSchemeQueueBinding(){
        // 将交换机和删除队列绑定
        return BindingBuilder.bind(delProductQueue()).to(directProductUpExchange()).with("delProduct_direct_rk").noargs();
    }


}
