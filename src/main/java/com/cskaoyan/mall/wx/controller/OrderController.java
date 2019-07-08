package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author xiaolong
 * date: 2019-07-03 19:58
 * description:
 */
/*@RestController
@RequestMapping("wx/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("list")
    public ResponseVo orderList(int page, int limit, String sort, String order, Integer userId, String orderSn, Integer[] orderStatusArray) {
        ResponseVo vo = orderService.orderList(page, limit, sort, order, userId, orderSn, orderStatusArray);
        return vo;
    }

    @RequestMapping("detail")
    public ResponseVo orderDetail(int id) {
        ResponseVo vo = orderService.orderDetail(id);
        return vo;
    }

}*/
