package houzm.accumulation.limit.limit.strategy.limit;

import houzm.accumulation.limit.context.SpringContextHolder;
import houzm.accumulation.limit.limit.Limit;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Package: houzm.accumulation.limit.limit.strategy.limit
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 13:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： limit windows redis
 */
public class LimitStrategyWindowsRedis extends AbstractLimitStrategy {
    private final byte[] bytes = new byte[1]; //减小锁大小，减小每次读锁的消耗

    public LimitStrategyWindowsRedis(Limit limit) {
        super(limit);
    }

    @Override
    public Boolean execute(String key) {
        boolean isLimited = true;
        StringRedisTemplate redisTemplate = SpringContextHolder.getBean("stringRedisTemplate");
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        // 考虑并发情况，下列操作必须原子
        synchronized (bytes) {
            String limitCount = opsForValue.get(key); //这里消耗过大，建议放在锁内
            System.out.println("剩余过期时间："+redisTemplate.getExpire(key));
            if (limitCount == null || limitCount.trim().length() == 0) {
                limitCount = "1";
                opsForValue.set(key, limitCount, limit.time(), limit.timeunit());
//                opsForValue.increment(key, 1L);
//                Boolean expireEffective = redisTemplate.expire(key, limit.time(), limit.timeunit());
            } else {
                Long increment = opsForValue.increment(key, 1);
                if (increment > limit.limit()) {
                    isLimited = false;
                }
            }
        }
        return isLimited;
    }
}
