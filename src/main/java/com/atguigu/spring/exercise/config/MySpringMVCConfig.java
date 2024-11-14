package com.atguigu.spring.exercise.config;


import com.atguigu.spring.exercise.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer{


    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    // 添加自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加一个自定义拦截器");
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**");
    }


   /*  @Bean
    WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                System.out.println("MySpringMVCConfig.addInterceptors()");
            }
        };
    }*/
}
