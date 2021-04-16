package com.csw.xuxianUser.xuxianBase.xuxianArticle.dao;

import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
