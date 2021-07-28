package com.project.common.util;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 发送消息的工具类
 */
@Component
public class MQUtil {
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息给交换机，并指定对应的路由键和消息内容
     *
     * @param exchangeName
     * @param routingKey
     * @param message
     */
    public void send(String exchangeName, String routingKey, Object message) {
        this.rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    public void ack(Message message, Channel channel) {
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nack(Message message, Channel channel) {
        try {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}