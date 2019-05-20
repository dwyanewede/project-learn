package com.learn.demo.spring.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ApplicationEventListener
 * @Description: web容器关闭，事件监听模拟实现
 * @Author: 尚先生
 * @CreateDate: 2019/5/20 14:40
 * @Version: 1.0
 */
@Component
public class ApplicationEventListener implements ApplicationListener {

    private final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    public void onApplicationEvent(ApplicationEvent event) {

        //容器关闭时触发的事件
        if(event instanceof ContextClosedEvent){
            logger.info(event.getClass().getName() + " application close ...");
        }else{
            logger.info(event.getClass().getName() + " application other event ...");

        }
    }
}