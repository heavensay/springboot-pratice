package com.ljy.spt.portal.web;

import com.ljy.spt.portal.config.event.HelloEventPublisher;
import com.ljy.spt.portal.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;


@Controller
@RequestMapping("hello")
@Validated
public class HelloController {

    @Value("${custom.msg}")
    private String msg;

    @Value("${custom.num}")
    private Integer num;

    @Autowired
    private HelloEventPublisher helloEventPublisher;
    @Autowired
    private HelloService helloService;


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

    /**
     * 测试validation对方法级别的验证
     * @NotNull注释放开就能验证；
     * @param content
     * @return
     */
    @RequestMapping("/validation")
    @ResponseBody
    public String validation(/*@NotNull(message = "Controller参数不能为空")*/ String content){
        return helloService.validation(content);
    }


}
