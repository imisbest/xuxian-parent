package com.csw.xuxianUser.xuxianBase.xuxianArticle.controller;

import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import com.csw.xuxianCommon2.utils.JwtUtil;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.Admin;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("regist")
    public Result regist(@RequestBody Admin admin) {
        adminService.regist(admin);
        return new Result(true, StatusCode.OK, "注册成功", null);
    }

    @PostMapping("login")
    public Result login(@RequestBody Admin admin) {
        Admin login = adminService.login(admin);
        if (login == null) {
            return new Result(false, StatusCode.LOGINERROR, "登录失败", null);
        }
        //登录成功颁发token


        String token = jwtUtil.createJWT(login.getId(), login.getLoginName(), "admin");
        System.out.println("token]" + token);
        Map map = new HashMap();
        map.put("token", token);
        map.put("name", login.getLoginName());
        return new Result(true, StatusCode.OK, "登录成功", map);
    }


}
