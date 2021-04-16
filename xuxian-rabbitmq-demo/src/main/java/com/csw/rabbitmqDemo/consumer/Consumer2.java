package com.csw.rabbitmqDemo.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "csw1")
public class Consumer2 {

    @RabbitHandler
    public void showMsg(String msg) {
        System.out.println("从csw1获取到了goods.log消息" + msg);
    }

}
