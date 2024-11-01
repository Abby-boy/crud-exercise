package com.atguigu.spring.exercise.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    // 配置 mybatis 分页插件
    @Bean
    PageInterceptor pageInterceptor() {

        // 创建分页插件 PageInterceptor 对象
        PageInterceptor interceptor = new PageInterceptor();
        // 设置属性
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        interceptor.setProperties(properties);
        return interceptor;
    }
}
