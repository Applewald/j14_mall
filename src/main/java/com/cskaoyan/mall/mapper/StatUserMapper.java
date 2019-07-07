package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.statictics.GoodsStat;
import com.cskaoyan.mall.bean.statictics.OrderStat;
import com.cskaoyan.mall.bean.statictics.UserStat;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/5 20:45
 */

public interface StatUserMapper {


    List<OrderStat> getOrderStatList();

    List<GoodsStat> getGoodsStatList();

    List<UserStat> getUserStatList();
}
