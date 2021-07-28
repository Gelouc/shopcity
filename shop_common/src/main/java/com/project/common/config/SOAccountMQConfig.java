package com.project.common.config;

import com.project.common.util.MQUtil;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**前端客户订单发送审核系统MQ
 * @author wangsj
 */
@Configuration
@EnableRabbit
public class SOAccountMQConfig {

    @Resource
    private MQUtil mqUtil;
    @Bean
    public Exchange directSoAccountExchange(){
        // 创建销售订单接收的交换机
        return ExchangeBuilder.directExchange("soAccount.direct.exchange").durable(true).build();
    }


    @Bean
    public Queue directSoAccountQueue(){
        // 创建销售订单消息的队列
        return new Queue("soAccount.direct.queue",true);
    }


    @Bean
    public Binding directSoAccountExchangeDirectSoAccountQueueBinding(){
        // 将交换机和注册队列绑定
        return BindingBuilder.bind(directSoAccountQueue()).to(directSoAccountExchange()).with("SoAccount_rk").noargs();
    }
}
