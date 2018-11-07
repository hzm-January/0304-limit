package houzm.accumulation.limit.limit.strategy.limit;

import houzm.accumulation.limit.limit.Limit;

/**
 * Package: com.nair.pss.res.common.annotations.limit.strategy
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 14:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： AbstractLimitStrategy
 */
public abstract class AbstractLimitStrategy implements LimitStrategy {

    protected Limit limit;

    public AbstractLimitStrategy(Limit limit) {
        this.limit = limit;
    }
}
