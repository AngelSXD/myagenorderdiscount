package com.agen.config;

import com.agen.interceptpr.ViewInterceptpr;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomizeConfig extends WebMvcConfigurerAdapter {


    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ViewInterceptpr()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login","/js/**","/bootstrap-3.3.7/**");
        super.addInterceptors(registry);
    }

    /**
     * 添加自定义页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("login").setViewName("login");
        super.addViewControllers(registry);
    }
}