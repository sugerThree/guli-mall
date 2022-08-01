package com.three.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 *
 * 2、逻辑删除
 *  1）、配置全局逻辑删除规则
 *  2）、配置逻辑删除组件（3.1.1之后不需要）
 *  3）、要逻辑删除字段添加@TableLogic    (value = "1",delval = "0")(字段不一致加)
 * @author three
 */
@MapperScan("com.three.gulimall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
