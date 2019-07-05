package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author lixiaolong
 * date: 2019-07-05 17:56
 * description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public int orderTotal() {
        return orderMapper.orderTotal();
    }
}
