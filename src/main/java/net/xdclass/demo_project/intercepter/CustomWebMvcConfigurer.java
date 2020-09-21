package net.xdclass.demo_project.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName : CustomWebMvcConfigurer  //类名
 * @Description : 拦截器配置类 //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-21 20:25  //时间
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**");
        //registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public LoginIntercepter getLoginInterceptor(){
        return  new LoginIntercepter();
    }
}
