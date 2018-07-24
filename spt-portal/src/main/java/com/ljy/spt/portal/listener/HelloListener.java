package com.ljy.spt.portal.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {

    @EventListener
    public void onListen(String msg){
        System.out.println("the listen msg:"+msg);
    }

}
