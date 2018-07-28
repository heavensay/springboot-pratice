package com.ljy.spt.portal.web;

import com.ljy.spt.autoconfigure.TimeEnhance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@RequestMapping("autoconfig")
public class AutoConfigController {


    @Autowired
    TimeEnhance timeEnhance;

    /**
     * 测试时间格式是否来自application.yml
     */
    @RequestMapping("/time")
    @ResponseBody
    public String time(){
        return timeEnhance.getFormatTime(new Timestamp(System.currentTimeMillis()));
    }

}
