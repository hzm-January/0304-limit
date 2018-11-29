package houzm.accumulation.limit.controller;

import houzm.accumulation.limit.context.SpringContextHolder;
import houzm.accumulation.limit.limit.Limit;
import houzm.accumulation.limit.limit.config.KeyStrategyType;
import houzm.accumulation.limit.limit.config.LimitStrategyType;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.accumulation.limit.controller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 10:33
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@RestController
@RequestMapping(value = "/api/limit/")
@DependsOn(value = "springContextHolder")
public class LimitController {

    @RequestMapping(value = "/redis")
    @Limit(timeunit = TimeUnit.MINUTES, time = 1, key= KeyStrategyType.URI, strategy = LimitStrategyType.WINDOWS_REDIS, limit = 2)
    public void limit() {
        RedisTemplate<Object, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");
        RedisTemplate<String, String> stringRedisTemplate = SpringContextHolder.getBean("stringRedisTemplate");
//        ValueOperations<Object, Object> opsForValue = redisTemplate.opsForValue();
        System.out.println(redisTemplate);
        System.out.println(stringRedisTemplate);
    }
}
