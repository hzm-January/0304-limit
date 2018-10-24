package houzm.accumulation.ratelimiter.controller;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.util.concurrent.RateLimiter;

/**
 * Package: houzm.accumulation.ratelimiter.controller
 * Author: houzm
 * Date: Created in 2018/10/21 21:51
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 平滑突发限流---令牌桶---guava smooth bursty
 */
@RestController
@RequestMapping(value = "/api/limit/smooth/")
public class GuavaSmoothBurstyCtrl {

    private Logger logger = LoggerFactory.getLogger(GuavaSmoothBurstyCtrl.class);

    private RateLimiter rateLimiter = RateLimiter.create(5); //每秒钟五个令牌

    @RequestMapping(value = "/bursty", method = RequestMethod.GET)
    public void limit() {
        boolean isAcquire = rateLimiter.tryAcquire(1, TimeUnit.SECONDS); //1s内获取不到，降级
        if (isAcquire) {
            logger.debug("=== invoke service, limit passed {} ===", System.currentTimeMillis());
        } else {
//            throw new IllegalStateException("资源有限，请稍后重试");
            logger.debug("=== 资源有限，稍后重试 {} ===", System.currentTimeMillis());
        }
    }
}
