package com.cqupt513.doubleliu.interceptors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                             .addPathPatterns("/**")//拦截所有访问该路径的请求
                                .excludePathPatterns("/").excludePathPatterns("/login").excludePathPatterns("/getVerify").excludePathPatterns("/static/**");//排除这些路径
    }
}
