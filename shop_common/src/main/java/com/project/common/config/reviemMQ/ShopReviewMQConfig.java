package com.project.common.config.reviemMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 审核和供应商采购交换机
 */
@Configuration
@EnableRabbit
public class ShopReviewMQConfig {
    @Bean
    public Exchange directReviewExchange(){
        // 创建促销订单的交换机
        return ExchangeBuilder.directExchange("review.direct.exchange").durable(true).build();
    }


    @Bean
    public Queue tenderAuditPromotionQueue(){
        // 创建促销消息的队列
        return new Queue("promotionAdd.direct.queue",true);
    }
    @Bean
    public Queue tenderSRPQueue(){
        // 创建供应商退货消息的队列
        return new Queue("srp.direct.queue",true);
    }




    @Bean
    public Binding directAuditPromotionExchangeTenderQueueBinding(){
        // 将交换机和促销消息的队列绑定
        return BindingBuilder.bind(tenderAuditPromotionQueue()).to(directReviewExchange()).with("promotionAdd_direct_rk").noargs();
    }

    @Bean
    public Binding directSRPQueueBinding(){
        // 将交换机和促销消息的队列绑定
        return BindingBuilder.bind(tenderSRPQueue()).to(directReviewExchange()).with("srp_direct_rk").noargs();
    }

}
