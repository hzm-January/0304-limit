package houzm.accumulation.limit.limit;

import houzm.accumulation.limit.limit.config.KeyStrategyType;
import houzm.accumulation.limit.limit.config.LimitStrategyType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Package: com.nair.pss.res.common.annotations.limit
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 10:50
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 时间窗限流
 *
 * 适用场景：
 *      接口时间窗限流 允许接口在时间n内请求m次
 * 为什么要使用该限流：
 *      防止部分接口处理时间过长，如果流量瞬间涌入，导致服务不可用，进而导致雪崩（例如：批量多程航班查询）
 *
 */
@Documented
@Inherited
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Limit {

    /**
     * 时间单位，默认单位：秒
     * @return
     */
    TimeUnit timeunit() default TimeUnit.SECONDS;

    /**
     * 限制时间频
     * 有的限流不适合进行时间窗设置，比如平滑限流
     * 如：限制api 5s内访问n次，可以设置time=5 timeunit = TimeUnit.SECONDS
     * @return
     */
    long time();

    /**
     * 生成key的策略
     * @return
     */
    KeyStrategyType key();

    /**
     * 限流策略
     * @return
     */
    LimitStrategyType strategy();

    /**
     * 限制访问次数
     * @return
     */
    int limit() default Integer.MAX_VALUE;
}
