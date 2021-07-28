package com.project.common.config.goodsMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class GoodsToBackMQ {
    @Bean
    public Exchange directgoodsToBackExchange(){
        //创建交换机
        return ExchangeBuilder.directExchange("direct.front.goodsAdd.exchange").durable(true).build();
    }
    //添加商品消息队列，传递GoodsDto,里面有goodsCode,goodsSaleprice
    @Bean
    public Queue directgoodsAddQueue(){
        //创建消息队列
        return new Queue("direct.front.goodsAdd.queue");
    }

    @Bean
    public Binding directgoodsAddExchangeQueueBinding(){
        //将交换机和消息队列绑定
        return BindingBuilder.bind(directgoodsAddQueue()).to(directgoodsToBackExchange()).with("direct_front_goodsAdd_rk").noargs();
    }


    //查询所有库存，传递pageNO
    @Bean
    public Queue directgoodsFindAllQueue(){
        //创建消息队列
        return new Queue("direct.front.goodsFindAll.queue");
    }

    @Bean
    public Binding directgoodsFindAllExchangeQueueBinding(){
        return BindingBuilder.bind(directgoodsFindAllQueue()).to(directgoodsToBackExchange()).with("direct_front_goodsFindAll_rk").noargs();
    }
}
