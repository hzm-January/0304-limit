package houzm.accumulation.limit.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.CacheLoader;

/**
 * Package: houzm.accumulation.limit.config
 * Author: houzm
 * Date: Created in 2018/10/16 5:36
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： cache config
 *
 */
//@Configuration
//proxyTargetClass = true基于类的代理(cglib)--缺省方式，false基于jdk标准接口的代理
//高版本spring自动根据运行的类选择jdk或者cglib代理，无需设置proxyTargetClass属性
//jdk动态代理模拟接口实现方式(一般使用该方式，效率高)，cglib模拟子类继承的方式
//如果 false, 并且没有实现接口，spring会自动使用cglib代理
//@EnableCaching(proxyTargetClass = true)
public class CacheConfig {

//    @Bean
//    public CacheLoader<Long, String> cacheLoader() {
//        new CacheLoader<Long, String>() {
//            @Override
//            public String load(Long key) throws Exception {
//                return null;
//            }
//
//            @Override
//            public String reload(Long key, String oldValue) throws Exception {
//                return null;
//            }
//        };
//    }

}
