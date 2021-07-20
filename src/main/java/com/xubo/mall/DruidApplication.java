package com.xubo.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/8/12 下午 03:24
 * <p>
 * exclude 的作用是指定该类手动配置，如果不用的话就全部自动配置
 * 57032
 * miui 历史版本下载 https://tieba.baidu.com/p/7229071169
 * am-asin表现 BigCatagory SmallCatagory 两张表 每次过滤通过Id去过滤，而且之前的 t_indicator_asin_category_info 也需要将大小类目的Id加上去
 *
 */
//@SpringBootApplication(exclude = {ElasticsearchAutoConfiguration})
//@ComponentScan(basePackages = {"com.xubo.mall.controller"})
@EnableAsync
@SpringBootApplication
public class DruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class);
    }
}
