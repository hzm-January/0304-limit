package houzm.accumulation.limit.limit.config;

/**
 * Package: com.nair.pss.res.common.annotations.limit
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 11:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 限流策略
 * 注： 堆内缓存限流策略适用于单机，集群限流需要使用堆外缓存
 */
public enum LimitStrategyType {

    /**
     * 时间窗限流-使用堆内缓存Caffeine
     */
    WINDOWS_CAFFEINE,
    /**
     * 时间窗限流-使用堆内缓存guava
     */
    WINDOWS_GUAVA,
    /**
     * 时间窗限流-使用堆外缓存redis
     */
    WINDOWS_REDIS,
    /**
     * 平滑限流-使用堆内缓存Guava
     */
    SMOOTH_GUAVA;
    ;

}
