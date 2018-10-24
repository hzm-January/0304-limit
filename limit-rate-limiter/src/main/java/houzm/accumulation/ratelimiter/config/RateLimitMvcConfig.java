package houzm.accumulation.ratelimiter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.accumulation.ratelimiter.config
 * Author: houzm
 * Date: Created in 2018/10/22 7:04
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： mvc config
 */
@Configuration
@EnableWebMvc
@ComponentScan("houzm")
public class RateLimitMvcConfig implements WebMvcConfigurer {
}
