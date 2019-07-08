package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.statictics.GoodsStat;
import com.cskaoyan.mall.admin.bean.statictics.OrderStat;
import com.cskaoyan.mall.admin.bean.statictics.UserStat;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/5 20:28
 */

public interface StatService {
    //Map queryStatUser();

    List<OrderStat> getOrderStatLIst();

    List<GoodsStat> getGoodsStatList();

    List<UserStat> getUserStatList();
}
