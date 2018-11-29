package houzm.accumulation.limit.limit.interceptor;

import houzm.accumulation.limit.limit.Limit;
import houzm.accumulation.limit.limit.strategy.key.KeyBuilder;
import houzm.accumulation.limit.limit.strategy.limit.LimitExecute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Package: com.nair.pss.res.common.annotations.limit
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 11:44
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： limit 拦截器
 */
public class LimitInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean flag = true;
        if (handler instanceof HandlerMethod) {
            Limit apiLimit = ((HandlerMethod) handler).getMethodAnnotation(Limit.class);
            // controller没有添加RepeatSubmitCheck注解, 直接返回true
            if (apiLimit != null) {
                //1. 根据key的策略生成key
                //2. 根据limit的限流策略进行限流
                Boolean execute = LimitExecute.execute(apiLimit, KeyBuilder.key(request, apiLimit.key()));
//                return execute;
                if (!execute) {
                    throw new IllegalStateException("系统繁忙，请稍后重试");
                }
            }
        }
        return flag;
    }
}
