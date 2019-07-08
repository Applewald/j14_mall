package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.service.StatService;
import com.cskaoyan.mall.admin.bean.statictics.GoodsStat;
import com.cskaoyan.mall.admin.bean.statictics.OrderStat;
import com.cskaoyan.mall.admin.bean.statictics.UserStat;
import com.cskaoyan.mall.admin.mapper.StatUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

