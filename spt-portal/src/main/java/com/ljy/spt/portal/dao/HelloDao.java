package com.ljy.spt.portal.dao;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author lijianyu
 * @date 2018/8/29 19:25
 */
@Repository
public class HelloDao {

    public String validation(@NotNull(message = "Dao参数不能为空") String content){
        return content+":"+new Date();
    }

}
