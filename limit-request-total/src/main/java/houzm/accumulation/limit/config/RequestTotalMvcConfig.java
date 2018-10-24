package houzm.accumulation.limit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.accumulation.limit.config
 * Author: houzm
 * Date: Created in 2018/10/12 12:53
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 接管mvc自动配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "houzm.accumulation.limit")
public class RequestTotalMvcConfig implements WebMvcConfigurer {

}
