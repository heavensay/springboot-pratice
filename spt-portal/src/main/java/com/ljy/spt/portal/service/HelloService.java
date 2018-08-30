package com.ljy.spt.portal.service;

import com.ljy.spt.portal.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author lijianyu
 * @date 2018/8/29 19:25
 */
@Service
public class HelloService {

    @Autowired
    HelloDao helloDao;

    public String validation(String content){
        return helloDao.validation(content);
    }

}
