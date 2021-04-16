package com.csw.xuxianUser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
/*<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>*/


/**
 * 账号是user
 * 在@SpringBootApplication注解上排除掉烦人的SpringSecurity，不要让它自动配置
 *
 * @SpringBootApplication(exclude={SecurityAutoConfiguration.class, OAuth2AutoConfiguration.class, SecurityFilterAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class,DataSourceAutoConfiguration.class})
 * ————————————————
 * 版权声明：本文为CSDN博主「Elsez」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/zhanxiaozhangA/java/article/details/105329501
 *///第二步
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()//所有请求都放行
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
