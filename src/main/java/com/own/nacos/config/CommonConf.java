package com.own.nacos.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
@Component
@RefreshScope
public class CommonConf {

    @Value("${time}")
    private Integer time;

    public Integer getTime() {
        return time;
    }

}
