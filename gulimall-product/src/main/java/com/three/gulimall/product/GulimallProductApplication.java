package com.three.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、整合MyBatis-plus
 *      1)、引入依赖
 *      2)、配置
 *          1、配置数据源
 *              1)、导入数据库驱动
 *              2)、application.yml中配置数据源
 *          2、配置MyBatis-plus
 *              1)、使用@MapperScan
 *              2)、yml中配置sql映射文件位置
 * @author three
 */
@MapperScan("com.three.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
