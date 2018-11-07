package houzm.accumulation.limit.limit.strategy.key;

import javax.servlet.http.HttpServletRequest;

/**
 * Package: com.nair.pss.res.business.common.limit.strategy.key
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 16:55
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： AbstractKeyStragegy
 */
public abstract class AbstractKeyStragegy implements keyStragegy {
    protected HttpServletRequest request;

    public AbstractKeyStragegy(HttpServletRequest request) {
        this.request = request;
    }
}
