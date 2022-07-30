package com.three.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 1、如何使用nacos作为配置中心统一管理配置
 * 1）、引入依赖
 * 2）、建bootstrap.properties文件，配置应用名和nacos配置中心地址
 * 3）、application.properties->@value读取配置文件信息
 * 在nacos中建  应用名.properties(默认规则)  配置文件，添加配置
 * 4）、读取配置内容的controller上添加 @RefreshScope(动态获取并刷新配置)+@value("${配置项的名}")
 * 优先使用配置中心的配置
 * 2、细节
 * 1）、命名空间：配置隔离；
 * 默认：public(保留空间)；默认新增的所有配置都在public空间。
 * 1、开发，测试，生产：利用命名空间来做环境隔离。
 * 注意：在bootstrap.properties；配置上，需要使用哪个命名空间下的配置，
 * spring.cloud.nacos.config.namespace=9de62e44-cd2a-4a82-bf5c-95878bd5e871
 * 2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 * 2）、配置集：所有的配置的集合
 * 3）、配置集ID：类似文件名。
 * Data ID：类似文件名
 * 4）、配置分组：
 * 默认所有的配置集都属于：DEFAULT_GROUP；
 * 1111，618，1212
 * 项目中的使用：每个微服务创建自己的命名空间，使用配置分组区分环境，dev，test，prod
 * 3、同时加载多个配置集
 * 1)、微服务任何配置信息，任何配置文件都可以放在配置中心中
 * 2）、只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
 * 3）、@Value，@ConfigurationProperties。。。
 * 以前SpringBoot任何方法从配置文件中获取值，都能使用。
 * 配置中心有的优先使用配置中心中的，
 *
 * @author three
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
