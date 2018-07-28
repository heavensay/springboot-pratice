package com.ljy.spt.portal.web;

import com.ljy.spt.portal.config.event.HelloEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("autoconfig")
public class HelloController {

    @Value("${custom.msg}")
    private String msg;

    @Value("${custom.num}")
    private Integer num;

    @Autowired
    private HelloEventPublisher helloEventPublisher;

    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "hello world,"+msg+",num:"+num;
    }

    /**
     * 事件触发
     * @param message
     * @return
     */
    @RequestMapping("/triggerEvent")
    @ResponseBody
    public String autoconfig(@RequestParam(value = "message",required = false) String message){
        helloEventPublisher.publishEvent(message);
        return "trigger ok";
    }

}
