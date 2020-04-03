package com.itcodai.course18.config;

import com.itcodai.course18.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义拦截器的配置，实现WebMvcConfigurer不会导致Spring Boot对mvc的自动配置失效
 * @author shengwu ni
 * @date 2018/08/03
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor())
                // 拦截所有url
                .addPathPatterns("/**")
                // 放行swagger
                .excludePathPatterns("/swagger-resources/**");
    }
}