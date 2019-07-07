package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.statictics.GoodsStat;
import com.cskaoyan.mall.bean.statictics.OrderStat;
import com.cskaoyan.mall.bean.statictics.UserStat;
import com.cskaoyan.mall.mapper.StatUserMapper;
import com.cskaoyan.mall.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/5 20:31
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    StatUserMapper statUserMapper;



    @Override
    public List<OrderStat> getOrderStatLIst() {
        return statUserMapper.getOrderStatList();
    }

    @Override
    public List<GoodsStat> getGoodsStatList() {
        return statUserMapper.getGoodsStatList();
    }

    @Override
    public List<UserStat> getUserStatList() {
        return statUserMapper.getUserStatList();
    }
}

