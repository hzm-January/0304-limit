package houzm.accumulation.limit.limit.strategy.key;

import houzm.accumulation.limit.limit.config.KeyStrategyType;
import javax.servlet.http.HttpServletRequest;

/**
 * Package: com.nair.pss.res.business.common.limit.strategy.key
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 16:12
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： key 生产者
 */
public class KeyBuilder {
    /**
     * 根据key的策略类型 生成key
     * @param keyStrategyType
     * @return
     */
    public static String key(HttpServletRequest request, KeyStrategyType keyStrategyType) {
        String requestURI = request.getRequestURI();
        switch (keyStrategyType) {
            case URI:
                return new KeyStragegyUri(request).key();
            case URI_PARAM:
                return new keyStragegyUriParams(request).key();
            default:
                return new KeyStragegyUri(request).key();
        }
    }
}
