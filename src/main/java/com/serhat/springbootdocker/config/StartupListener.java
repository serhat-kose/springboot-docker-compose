package com.serhat.springbootdocker.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.*;
import org.springframework.context.*;
import org.springframework.context.event.*;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public final void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("On Application Event is OK");
        cacheManager.getCacheNames().parallelStream().forEach(n -> {
            // cacheManager.getCache(n).clear()
            System.out.println(n);
        });
    }
}
