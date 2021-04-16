package com.csw.jjwtDemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJjwt {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJjc3ciLCJpYXQiOjE1OTQ5NTY4MDYsImV4cCI6MTU5NDk1Njg2NSwicm9sZXMiOiJhZG1pbiJ9.uClcqGWfR40-mKq4Uk-MvUGR6fzQha577ZiZ2ZgIPg8";
        Claims claims = Jwts.parser().setSigningKey("miyao").parseClaimsJws(token).getBody();
        System.out.println("id]" + claims.getId());
        System.out.println("账号】" + claims.getSubject());
        System.out.println("签发时间】" + claims.getIssuedAt());
        System.out.println("角色】" + claims.get("roles"));
    }
}
