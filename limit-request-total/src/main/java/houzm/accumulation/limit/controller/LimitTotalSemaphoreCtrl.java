package houzm.accumulation.limit.controller;

import java.util.concurrent.Semaphore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.accumulation.limit.controller
 * Author: houzm
 * Date: Created in 2018/10/12 21:15
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： limit for request total 限制接口请求总数---Semaphore
 */
@RestController
@RequestMapping("/api/limit/request/total")
public class LimitTotalSemaphoreCtrl {
    private Logger logger = LoggerFactory.getLogger(LimitTotalSemaphoreCtrl.class);
    private Semaphore semaphore = new Semaphore(5, true);

    @RequestMapping(value = "/semaphore", method = RequestMethod.GET)
    public void testLimit() {
        logger.debug("------------ test limit api: limit for request total by semaphore ------------");
        logger.debug("--- available permits {}", semaphore.availablePermits());
        boolean isAcuqire = semaphore.tryAcquire();//尝试获取许可
        if (isAcuqire) {
            logger.debug("=== semaphore acquire success ===");
        } else {
            throw new IllegalStateException("抱歉，资源已抢空");
        }

    }
}
