package com.project.common.config.reviemMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 审核用户交换机
 */
@Configuration
@EnableRabbit
public class AuditUserMQConfig {

    @Bean
    public Exchange directReviewExchange(){
        // 创建审核用户的交换机
        return ExchangeBuilder.directExchange("review.direct.auditUser.exchange").durable(true).build();
    }

    @Bean
    public Queue tenderAuditUserQueue(){
        // 创建审核用户的队列
        return new Queue("auditUser.direct.queue",true);
    }

//    @Bean
//    public Queue updateAuditUserQueue() {
//        // 创建修改审核用户状态的队列
//        return new Queue("updateUserStatus.direct.queue", true);
//    }

    @Bean
    public Binding directAuditUserExchangeTenderQueueBinding(){
        // 将交换机和审核用户的队列绑定
        return BindingBuilder.bind(tenderAuditUserQueue()).to(directReviewExchange()).with("auditUser_direct_rk").noargs();
    }

//    @Bean
//    public Binding directAuditUserExchangeUpdateQueueBinding(){
//        // 将交换机和修改审核用户状态的队列绑定
//        return BindingBuilder.bind(updateAuditUserQueue()).to(directReviewExchange()).with("updateUserStatus_direct_rk").noargs();
//    }

}
