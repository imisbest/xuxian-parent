package com.csw.xuxianUser.xuxianBase.xuxianArticle.service.impl;

import com.csw.xuxianCommon2.utils.IdWorker;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.dao.UserDao;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.User;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String mobile) {
        int sjs = new Random().nextInt(899999) + 100000;
        //或者Math.random()*899999+100000;
        System.out.println("手机号码是" + mobile + "===>验证码是" + sjs);
        //存入redis
        redisTemplate.opsForValue().set("sendMsg_" + mobile, sjs + "", 1, TimeUnit.MINUTES);
        //存入rabbit
        Map map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", sjs + "");
        rabbitTemplate.convertAndSend("xuxian", map);

    }

    @Override
    public void regist(User user, String code) {
        String sjs = (String) redisTemplate.opsForValue().get("sendMsg_" + user.getMobile());
        if (sjs == null) {
            throw new RuntimeException("验证码过期");
        }
        if (!sjs.equals(code)) {
            throw new RuntimeException("验证码输入错误");
        }
        user.setId(idWorker.nextId() + "");
        userDao.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteById(id);

    }
}
