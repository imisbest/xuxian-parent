package com.csw.jjwtDemo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJjwt {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        long exet = millis + 60 * 1000;//设置一分钟失效

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")//设置id
                .setSubject("csw")//设置主体
                .setIssuedAt(new Date())//设置日期
                .signWith(SignatureAlgorithm.HS256, "miyao")//设置认证密钥
                .setExpiration(new Date(exet))//设置过期时间
                .claim("roles", "admin");//授权主体

        System.out.println(jwtBuilder.compact());
        //eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJjc3ciLCJpYXQiOjE1OTQ5NTU1MDZ9.1B1LuJkkK8_UvmkLh8SQPK9tOTE4yfldPuwDygrrcK8
        //eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJjc3ciLCJpYXQiOjE1OTQ5NTU1ODB9.5Vdi_koGWz_WwiB0eWgMorw7TQ4It3J3HtPNtSZpOvo

    }


}
