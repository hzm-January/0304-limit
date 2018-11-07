package houzm.accumulation.limit.limit.strategy.key;

import javax.servlet.http.HttpServletRequest;

/**
 * Package: com.nair.pss.res.business.common.limit.strategy.key
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 16:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： KeyStragegyUri
 */
public class KeyStragegyUri extends AbstractKeyStragegy {

    public KeyStragegyUri(HttpServletRequest request) {
        super(request);
    }

    /**
     * 根据uri 生成 key
     * @return
     */

    @Override
    public String key() {
        return request.getRequestURI();
    }
}
