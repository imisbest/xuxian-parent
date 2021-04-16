package com.csw.xuxianUser.xuxianBase.xuxianArticle.service.impl;

import com.csw.xuxianCommon2.utils.IdWorker;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.dao.AdminDao;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.Admin;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void regist(Admin admin) {
        //设置自增主键
        admin.setId(idWorker.nextId() + "");
        //密码加密替换
        String encode = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        adminDao.save(admin);

    }

    @Override
    public Admin login(Admin admin) {
        System.out.println("admin]" + admin);
        //从数据库查找用户
        Admin loginName = adminDao.findAdminByLoginName(admin.getLoginName());
        System.out.println("loginName]" + loginName);
        if (loginName == null) {//用户为空，返回空
            return null;
        }

        //输入的密码跟查到的密码不匹配，返回空
        //match是将加密前的密码和加密后的密码比较
        if (!bCryptPasswordEncoder.matches(admin.getPassword(), loginName.getPassword())) {
            System.out.println("jin");
            return null;
        }
        return loginName;
    }


}
