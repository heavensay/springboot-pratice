package com.ljy.spt.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 时间属性配置类
 * @Author: lijianyu
 * @Date: 2018/7/23 19:47
 */
public class TimeProperties {

    /**
     * 时间格式
     */
    private String dateFormat ="yyyy-MM-dd HH:mm:ss";

    /**
     *
     * @return
     */
    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
