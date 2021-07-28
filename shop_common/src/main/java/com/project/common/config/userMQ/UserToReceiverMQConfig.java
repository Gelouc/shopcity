package com.project.common.config.userMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class UserToReceiverMQConfig {
    @Bean
    public Exchange directUserRegisterExchange(){
        // 创建用户的交换机
        return ExchangeBuilder.directExchange("direct.userRegister.exchange").durable(true).build();
    }

    //正式注册用户，传递userDot
    @Bean
    public Queue directUserRegisterQueue(){
        // 创建用户消息的队列
        return new Queue("direct.userRegister.queue",true);
    }

    @Bean
    public Binding directUserRegisterExchangeTenderQueueBinding(){
        // 将交换机和用户消息的队列绑定
        return BindingBuilder.bind(directUserRegisterQueue()).to(directUserRegisterExchange()).with("direct_userRegister_rk").noargs();
    }


    //消费等级
    @Bean
    public Queue directUserGradeQueue(){
        // 创建预存款的队列
        return new Queue("direct.userGrade.queue",true);
    }

    @Bean
    public Binding directUserGradeExchangeTenderQueueBinding(){
        // 将交换机和预存款消息的队列绑定
        return BindingBuilder.bind(directUserGradeQueue()).to(directUserRegisterExchange()).with("direct_userGrade_rk").noargs();
    }

    //审核正式用户 传递用户名和用户状态1,2
    @Bean
    public Queue directUserStateQueue(){
        // 创建用户消息的队列
        return new Queue("direct.reviewUserState.queue",true);
    }

    @Bean
    public Binding directUserStateExchangeTenderQueueBinding(){
        // 将交换机和用户消息的队列绑定
        return BindingBuilder.bind(directUserStateQueue()).to(directUserRegisterExchange()).with("direct_reviewUserState_rk").noargs();
    }
}
