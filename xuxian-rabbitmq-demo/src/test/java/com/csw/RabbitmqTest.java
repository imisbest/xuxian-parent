package com.csw;

import com.csw.rabbitmqDemo.RabbitmqDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqDemoApplication.class)
@RunWith(SpringRunner.class)
public class RabbitmqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test//生产者
    public void fun() {
        rabbitTemplate.convertAndSend("csw", "hello3");
    }

    @Test//分裂模式
    public void fun2() {

        rabbitTemplate.convertAndSend("jhq", "", "来自jhq的消息");
    }

    @Test//主题模式
    public void sengTopic() {

        rabbitTemplate.convertAndSend("jhq-topic", "goods.aaa", "主题模式的消息");
    }

    @Test//主题模式
    public void sengTopic2() {

        rabbitTemplate.convertAndSend("jhq-topic", "aaa.bbb.log", "主题模式的消息");
    }

    @Test//主题模式
    public void sengTopic3() {

        rabbitTemplate.convertAndSend("jhq-topic", "goods.log", "主题模式的消息");
    }

}
