package com.ljy.spt.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: lijianyu
 * @Date: 2018/7/23 19:47
 */
public class TimeProperties {

    private String dateFormat ="yyyy-MM-dd HH:mm:ss";

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
