package houzm.accumulation.limit.limit.strategy.limit;

/**
 * Package: com.nair.pss.res.common.annotations.limit.strategy
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 14:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： LimitStrategyType 限流策略顶层接口
 */
public interface LimitStrategy {

    Boolean execute(String key);
}
