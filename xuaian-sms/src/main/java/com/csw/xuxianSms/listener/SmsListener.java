package com.csw.xuxianSms.listener;

import com.csw.xuxianSms.util.MessageSend;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "xuxian")
public class SmsListener {
    @Value("${aliyun.sms.signName}")
    private String signName;
    @Value("${aliyun.sms.templateCode}")
    private String templateCode;
    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.sms.accessSecret}")
    private String accessSecret;

    @RabbitHandler
    public void sendCode(Map<String, String> map) {
        MessageSend.send(map.get("mobile"), map.get("code"), signName, templateCode, accessKeyId, accessSecret);
    }
}
