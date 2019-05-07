package com.ljy.spt.portal.web;

import com.ljy.spt.portal.config.event.HelloEventPublisher;
import com.ljy.spt.portal.service.HelloService;
import com.ljy.spt.portal.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;

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

    /**
     * json格式数据支持
     * @return
     */
    @GetMapping(value = "/getJsonData")
    @ResponseBody
    public HelloBean getJsonData(){
        HelloBean bean = new HelloBean();
        bean.setContent("hello world");
        bean.setId(1);

        return bean;
    }

    /**
     * json格式数据支持
     * @return
     */
    @GetMapping(value = "/getCache1")
    @ResponseBody
    @Cacheable(value = "cache1",key = "#key")
    public String getCache1(String key){
        return key+System.currentTimeMillis();
    }

    /**
     * json格式数据支持
     * @return
     */
    @GetMapping(value = "/getCache2")
    @ResponseBody
    @Cacheable(value = "cache2",key = "#key")
    public String getCache2(String key){
        return key+System.currentTimeMillis();
    }

    /**
     * json格式数据支持
     * @return
     */
    @GetMapping(value = "/getCache1ForCode")
    @ResponseBody
    public String getCache1ForCode(String key){
        CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);
        Cache cache = cacheManager.getCache("cache1");

        return cache.get(key) != null?(String)(cache.get(key).get()):null;
    }


    class HelloBean{
        private int id;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


}
