package com.guangeryi.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class BaseConfig {

    /**
     * 异步事件广播器
     * 
     */
    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
    	SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
    	applicationEventMulticaster.setTaskExecutor(taskExecutor());
    	return applicationEventMulticaster;
    }
    /**
     * 任务执行器
     * 
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
    	ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    	taskExecutor.setThreadNamePrefix("pre-demo");
    	taskExecutor.setCorePoolSize(10);
    	taskExecutor.setMaxPoolSize(20);
    	taskExecutor.setQueueCapacity(25);
    	return taskExecutor;
    }
}
