package houzm.accumulation.limit.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Package: houzm.accumulation.limit.context
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/14 10:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： SpringContextHolder
 *
 * 在启动时获取applicationContext
 * 注： 必须启动时扫描到SpringContextHolder，将其添加到ioc
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        Assert.notNull(applicationContext, "ApplicationContext为空，检查SpringContextHolder是否被注入");
        return applicationContext;
    }

    /**
     * 根据bean name 获取bean
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName) {
        Assert.notNull(applicationContext, "ApplicationContext为空，检查SpringContextHolder是否被注入");
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 根据bean class 获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        Assert.notNull(applicationContext, "ApplicationContext为空，检查SpringContextHolder是否被注入");
        return applicationContext.getBean(clazz);
    }

}
