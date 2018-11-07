package houzm.accumulation.limit.limit.strategy.limit;

import houzm.accumulation.limit.limit.Limit;

/**
 * Package: com.nair.pss.res.common.annotations.limit.strategy
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 14:05
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 限流执行
 */
public class LimitExecute {

    /**
     * 执行
     * @param limit 限流配置
     */
    public static Boolean execute(Limit limit, String key) {
        switch (limit.strategy()) {
            case WINDOWS_GUAVA:
                return new LimitStrategyWindowsGuava(limit).execute(key);
            default:
                return new LimitStrategyWindowsGuava(limit).execute(key);
        }
    }

}
