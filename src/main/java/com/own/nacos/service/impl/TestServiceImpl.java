package com.own.nacos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.own.nacos.entity.CityInfo;
import com.own.nacos.mapper.CityInfoMapper;
import com.own.nacos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private CityInfoMapper cityInfoMapper;
    @Override
    public Object getFromMysql() {
        List<CityInfo> cityInfos = cityInfoMapper.selectList(new QueryWrapper<>());
        return cityInfos;
    }
}
