package com.xubo.mall.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Druid_Xu
 * @Date 2020/11/6 上午 11:39
 * @Description
 * 配置类 配置跨域请求 ，放开所有的请求路径及方式
 *
 */
@Configuration
public class ConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 允许跨越发送cookie
        config.setAllowCredentials(true);
        //放行全部原始头信息
        config.addAllowedHeader("*");
        //允许所有请求方法跨域调用
        config.addAllowedMethod("*");
        //允许所有域名进行跨域调用
        config.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
