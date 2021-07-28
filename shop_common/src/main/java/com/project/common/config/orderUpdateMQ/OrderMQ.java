package com.project.common.config.orderUpdateMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class OrderMQ {
    @Bean
    public Exchange directFrontOrderExchange(){
        // 创建下订单交换机
        return ExchangeBuilder.directExchange("frontOrder.direct.exchange").durable(true).build();
    }


    @Bean
    public Queue frontOrderQueue(){
        // 创建队列
        return new Queue("frontOrder.direct.queue",true);
    }



    @Bean
    public Binding directFrontOrderExchangeTenderQueueBinding(){
        // 将交换机和消息的队列绑定
        return BindingBuilder.bind(frontOrderQueue()).to(directFrontOrderExchange()).with("frontOrder_direct_rk").noargs();
    }

}
