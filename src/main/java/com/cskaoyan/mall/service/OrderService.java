package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author: xiaolong
 * date: 2019-07-05 17:55
 * version: 1.0
 * description:
 */
public interface OrderService {

    int orderTotal();

    ResponseVo orderList(int page, int limit, String sort, String order,Integer userId,String orderSn,Integer[] orderStatusArray);

    ResponseVo orderDetail(int id);
}
