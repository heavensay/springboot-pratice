package com.ljy.spt.portal.config.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloEventPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publishEvent(String message){
        applicationContext.publishEvent(message);
    }

}
