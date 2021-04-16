package com.csw.rabbitmqDemo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component//直接模式
@RabbitListener(queues = "csw")
public class Consumer {
    @RabbitHandler
    public void showMsg(String msg) {
        System.out.println("从csw获取到了goods.*消息" + msg);
    }
}
