package com.csw.rabbitmqDemo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "csw2")
public class Consumer3 {
    @RabbitHandler
    public void showMsg(String msg) {
        System.out.println("从csw2获取到了*.log消息" + msg);
    }
}
