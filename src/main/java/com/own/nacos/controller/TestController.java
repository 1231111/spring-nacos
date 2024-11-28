package com.own.nacos.controller;

import com.own.nacos.config.CommonConf;
import com.own.nacos.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/city")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private CommonConf commonConf;
    @Autowired
    private DataSource dataSource;

    @GetMapping(value = "/list")
    public Object getAllCityList() {
        return testService.getFromMysql(); // 直接映射到R对象，假设R类有适当的构造或静态方法
    }

    @GetMapping(value = "/k")
    public Object getv() {
        return commonConf.getTime(); // 直接映射到R对象，假设R类有适当的构造或静态方法
    }

}
