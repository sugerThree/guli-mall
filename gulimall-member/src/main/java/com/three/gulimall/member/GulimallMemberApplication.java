package com.three.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *远程调用
 *      1）、引入open-feign
 *      2）、编写接口->声明调用的是哪个接口
 *      3）、开启远程调用功能->@EnableFeignClients
 *
 * @author three
 */
@EnableFeignClients(basePackages = "com.three.gulimall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
