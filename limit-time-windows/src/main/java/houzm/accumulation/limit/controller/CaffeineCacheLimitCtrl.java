package houzm.accumulation.limit.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

/**
 * Package: houzm.accumulation.limit.controller
 * Author: houzm
 * Date: Created in 2018/10/15 21:40
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 限制某个接口的时间窗请求数---使用caffeine
 *
 * 每秒允许3次访问
 * 每秒1秒重新统计
 */
@RestController
@RequestMapping(value = "/api/limit/request/windows")
public class CaffeineCacheLimitCtrl {
    private Logger logger = LoggerFactory.getLogger(CaffeineCacheLimitCtrl.class);
    private LoadingCache<String, AtomicInteger> cache = Caffeine.newBuilder().expireAfterWrite(1L, TimeUnit.SECONDS).build(new CacheLoader<String, AtomicInteger>() {
        @Override
        public AtomicInteger load(String key) throws Exception {
            return new AtomicInteger(); //初始化为1
        }
    });


    @RequestMapping(value = "/caffeine", method = RequestMethod.GET)
    public void limit() {
        logger.debug("=== caffeine welcome thread {} requst the ctrl for limit window ===", Thread.currentThread().getName());
        AtomicInteger limitwindows = cache.getIfPresent("limitwindows");
        if (limitwindows == null) {
            logger.debug("limitwindow is null");
            limitwindows = cache.get("limitwindows", s -> new AtomicInteger(1));
        }
        logger.debug("limitwindows in cache value is : {}", limitwindows.intValue());
        int count = limitwindows.getAndIncrement();
        if (count > 3) {
            throw new IllegalStateException("访问频繁，稍后再试");
        } else {
            logger.debug("=== invoke service, thread {} caffeine limit passed  ===", Thread.currentThread().getName());
        }
    }
}
