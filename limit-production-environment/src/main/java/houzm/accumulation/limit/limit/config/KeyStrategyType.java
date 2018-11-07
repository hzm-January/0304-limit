package houzm.accumulation.limit.limit.config;

/**
 * Package: com.nair.pss.res.common.annotations.limit
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 11:24
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： limit 限流 key的保存策略
 *
 */
public enum KeyStrategyType {
    /**
     * key = api url
     */
    URI,
    /**
     * key = api url + api params
     */
    URI_PARAM,
    /**
     * key = ip
     */
    IP;
}
