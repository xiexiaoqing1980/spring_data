package com.example.demo.config;

//import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    //configure the homepage
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("login");
        //注册首页：
        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/success").setViewName("itemslist.html"); //配置登陆页映射
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/login","/login.html");  //需要放行的路径；
//        super.addInterceptors(registry);
    }*/
}
