package com.example.moviereviewweb.config;

import com.example.moviereviewweb.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {//注册拦截器

    @Autowired
    private LoginInterceptor loginInterceptor;//引入拦截器对象

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //调用注册拦截器的方法api。http://localhost:8080/classes
        //TODO 用户登录拦截配置
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/signup","/login");
        //设置拦截路径和不拦截的路径

    }
}
