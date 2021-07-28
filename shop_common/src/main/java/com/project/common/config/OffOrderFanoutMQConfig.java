package com.project.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class OffOrderFanoutMQConfig {
    //创建退货订单广播交换机
    @Bean
    public FanoutExchange offOrderfanoutExchange(){
        return new FanoutExchange("offOrder.fanout.exchange",true,false);
    }
    //创建退货单队列a
    @Bean
    public Queue offOrderFanoutQueueA(){
        return new Queue("offOrder.fanout.queue.a",true);
    }
    //创建退货单队列b
    @Bean
    public Queue offOrderFanoutQueueB(){
        return new Queue("offOrder.fanout.queue.b",true);
    }
    //创建退货单队列c
    @Bean
    public Queue offOrderFanoutQueueC(){
        return new Queue("offOrder.fanout.queue.c",true);
    }
    @Bean
    public Binding fanoutExchangeQueueABinding(){
        return BindingBuilder.bind(offOrderFanoutQueueA()).to(offOrderfanoutExchange());
    }
    @Bean
    public Binding fanoutExchangeQueueBBinding(){
        return BindingBuilder.bind(offOrderFanoutQueueB()).to(offOrderfanoutExchange());
    }
    @Bean
    public Binding fanoutExchangeQueueCBinding(){
        return BindingBuilder.bind(offOrderFanoutQueueC()).to(offOrderfanoutExchange());
    }
}
