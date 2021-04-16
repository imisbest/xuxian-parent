package com.csw.xuxianUser.xuxianBase.xuxianArticle.service;

import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.User;

public interface UserService {
    //发送短信
    void sendMsg(String mobile);

    //注册用户
    void regist(User user, String code);

    //删除用户
    void deleteUserById(String id);
}
