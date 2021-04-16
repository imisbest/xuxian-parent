package com.csw.xuxianUser.xuxianBase.xuxianArticle.controller;

import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import com.csw.xuxianCommon2.utils.JwtUtil;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.entity.User;
import com.csw.xuxianUser.xuxianBase.xuxianArticle.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtil jwtUtil;

    //发送验证码
    @PostMapping("sendMsg/{mobile}")
    public Result sendMsg(@PathVariable("mobile") String mobile) {
        System.out.println("进到sendMsg方法");
        userService.sendMsg(mobile);
        return new Result(true, StatusCode.OK, "发送验证码成功", null);
    }

    //注册用户
    @PostMapping("addUser/{code}")
    public Result addUser(@RequestBody User user,
                          @PathVariable("code") String code) {
        userService.regist(user, code);
        return new Result(true, StatusCode.OK, "注册成功", null);
    }

    @GetMapping("sayHi")
    public String sayHi() {

        return "hello World!";
    }

    @DeleteMapping("deleteUserById/{id}")
    public Result deleteUserById(@PathVariable("id") String id) {
        String token = request.getHeader("AuthorToken");
        //判断是否为空
        if (token == null || "".equals(token)) {
            return new Result((false), StatusCode.ACCESSERROR, "权限不足token=null", null);
        }
        //判断是否以约定的字符串开头
        if (!token.startsWith("chaofan_")) {
            return new Result((false), StatusCode.ACCESSERROR, "权限不足token开头不匹配", null);
        }
        //截取到真正token
        String relToken = token.substring(8);
        //解密
        Claims claims = jwtUtil.parseJWT(relToken);
        System.out.println("claims]" + claims);
        //判断是否有权限
        if (claims == null) {
            return new Result((false), StatusCode.ACCESSERROR, "权限不足，解密失败", null);
        }
        if (!"admin".equals(claims.get("roles"))) {
            return new Result((false), StatusCode.ACCESSERROR, "权限不足，角色不正确", null);
        }
        userService.deleteUserById(id);
        return new Result(true, StatusCode.OK, "删除成功", null);
    }

    @DeleteMapping("deleteUserById2/{id}")
    public Result deleteUserById2(@PathVariable("id") String id) {
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims == null) {
            return new Result((false), StatusCode.ACCESSERROR, "权限不足", null);
        }
        userService.deleteUserById(id);
        return new Result(true, StatusCode.OK, "删除成功", null);
    }
}
