package com.ljy.spt.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//开启配置
//@EnableConfigurationProperties(TimeProperties.class)//开启使用映射实体对象
//@ConditionalOnClass(HelloService.class)//存在HelloService时初始化该配置类
//@ConditionalOnProperty//存在对应配置信息时初始化该配置类
public class TimeEnhanceAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(TimeEnhanceAutoConfiguration.class);

    /**
     * 服务类
     * 根据条件判断不存在TimeEnhance时初始化新bean到SpringIoc
     *
     * @return
     */
    @Bean  //创建HelloService实体bean
    @ConditionalOnMissingBean(TimeEnhance.class) //缺失TimeEnhance实体bean时，初始化TimeEnhance并添加到SpringIoc
    public TimeEnhance timeEnhance() {
        TimeProperties timeProperties = timeProperties();
        TimeEnhance timeEnhance = new TimeEnhance();
        timeEnhance.setDataFormat(timeProperties.getDateFormat());
        logger.info("declare TimeEnhance  [{}];",timeEnhance);

        return timeEnhance;
    }

    /**
     * 配置文件
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "time")
    public TimeProperties timeProperties() {
        return new TimeProperties();
    }

}
