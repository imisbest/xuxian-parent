package com.csw.xuxianBase;

import com.csw.xuxianCommon2.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class XuxianBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(XuxianBaseApplication.class);

    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
