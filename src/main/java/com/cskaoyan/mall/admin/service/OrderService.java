package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author: xiaolong
 * date: 2019-07-05 17:55
 * version: 1.0
 * description:
 */
public interface OrderService {

    int orderTotal();

    ResponseVo orderList(int page, int limit, String sort, String order, Integer userId, String orderSn, Integer[] orderStatusArray);

    ResponseVo orderDetail(int id);
}
