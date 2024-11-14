package com.atguigu.spring.exercise.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 过滤器
//@WebFilter(urlPatterns = "/hello")  拦截指定的请求
@Component
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器前置通知");
        filterChain.doFilter(request, response);
        System.out.println("过滤器后置通知");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
