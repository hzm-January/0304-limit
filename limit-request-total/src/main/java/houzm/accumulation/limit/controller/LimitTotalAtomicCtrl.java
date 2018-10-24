package houzm.accumulation.limit.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.accumulation.limit.controller
 * Author: houzm
 * Date: Created in 2018/10/12 12:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： limit for requset total 限制接口请求总数-----Atomic
 * 使用场景：抢购，超出限额之后进行
 *              1.服务降级通知用户已抢空
 *              2.进入队列进行排队
 * logger for jemeter 130 reqeusts
 * 2018-10-12 13:25:20.251 DEBUG 24236 --- [nio-1988-exec-5] h.a.l.controller.LimitRequestTotalCtrl   : ------------ test limit api: limit for request total ------------
 * 2018-10-12 13:25:20.251 DEBUG 24236 --- [nio-1988-exec-5] h.a.l.controller.LimitRequestTotalCtrl   : request : 118
 * 2018-10-12 13:25:20.329 DEBUG 24236 --- [nio-1988-exec-8] h.a.l.controller.LimitRequestTotalCtrl   : ------------ test limit api: limit for request total ------------
 * 2018-10-12 13:25:20.329 DEBUG 24236 --- [nio-1988-exec-8] h.a.l.controller.LimitRequestTotalCtrl   : request : 119
 * 2018-10-12 13:25:20.406 DEBUG 24236 --- [nio-1988-exec-9] h.a.l.controller.LimitRequestTotalCtrl   : ------------ test limit api: limit for request total ------------
 * 2018-10-12 13:25:20.406 DEBUG 24236 --- [nio-1988-exec-9] h.a.l.controller.LimitRequestTotalCtrl   : request : 120
 * 2018-10-12 13:25:20.483 DEBUG 24236 --- [nio-1988-exec-2] h.a.l.controller.LimitRequestTotalCtrl   : ------------ test limit api: limit for request total ------------
 * 2018-10-12 13:25:20.483 DEBUG 24236 --- [nio-1988-exec-2] h.a.l.controller.LimitRequestTotalCtrl   : access denied : request total is greater 120
 * 2018-10-12 13:25:20.558 DEBUG 24236 --- [nio-1988-exec-3] h.a.l.controller.LimitRequestTotalCtrl   : ------------ test limit api: limit for request total ------------
 * 2018-10-12 13:25:20.558 DEBUG 24236 --- [nio-1988-exec-3] h.a.l.controller.LimitRequestTotalCtrl   : access denied : request total is greater 120
 */
@RestController
@RequestMapping("/api/limit/request/total")
public class LimitTotalAtomicCtrl {

    private Logger logger = LoggerFactory.getLogger(LimitTotalAtomicCtrl.class);
    private AtomicLong requestTotal = new AtomicLong();
    private long limit = 120;

    @RequestMapping(value = "/atomic", method = RequestMethod.GET)
    public void testLimit() {
        logger.debug("------------ test limit api: limit for request total ------------");
        if (requestTotal.get() < limit) {
            logger.debug("request : {}", requestTotal.incrementAndGet());
        } else { // 降级策略
            logger.debug("access denied : request total is greater 120");
        }

    }
}
