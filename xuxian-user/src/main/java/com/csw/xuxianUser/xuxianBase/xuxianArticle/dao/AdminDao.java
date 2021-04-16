package com.csw.xuxianUser.xuxianBase.xuxianArticle.dao;

import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    //根据用户名查找用户,第五步
    Admin findAdminByLoginName(String loginName);
}
