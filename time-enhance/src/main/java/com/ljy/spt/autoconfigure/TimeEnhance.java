package com.ljy.spt.autoconfigure;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeEnhance {

    private String dataFormat ="yyyy-MM-dd HH:mm:ss";

    public String getFormatTime(Timestamp time){
        DateFormat format = new SimpleDateFormat(dataFormat);
        return format.format(time);
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
}
