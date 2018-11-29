package houzm.accumulation.limit.config;

import houzm.accumulation.limit.limit.interceptor.LimitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.accumulation.limit.config
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 17:25
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： MvcConfig
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LimitInterceptor limitInterceptor() {
        return new LimitInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(limitInterceptor()).addPathPatterns("/api/**");
    }
}
