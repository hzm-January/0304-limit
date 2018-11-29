package houzm.accumulation.limit.limit.strategy.limit;

import houzm.accumulation.limit.limit.Limit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.sun.istack.internal.NotNull;

/**
 * Package: com.nair.pss.res.common.annotations.limit.strategy
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 14:13
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 本地缓存
 */
public class LimitStrategyWindowsGuava extends AbstractLimitStrategy {


    private com.google.common.cache.LoadingCache<String, AtomicInteger> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(limit.limit(), limit.timeunit())
            .build(new CacheLoader<String, AtomicInteger>() {
        @Override
        public AtomicInteger load(String s) throws Exception {
            return new AtomicInteger(1);
        }
    });

    public LimitStrategyWindowsGuava(Limit limit) {
        super(limit);
    }

    @Override
    public Boolean execute(String key) {
        Boolean flag = true;
        AtomicInteger atomicInteger = null;
        try {
            atomicInteger = cache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (atomicInteger == null) {
            flag = false; //默认 如果抛出异常或者键值未获取到 不允许执行api
        } else {
            if (atomicInteger.getAndIncrement() > limit.limit()) {
                flag = false;
            }
        }
        return flag;
    }

}
