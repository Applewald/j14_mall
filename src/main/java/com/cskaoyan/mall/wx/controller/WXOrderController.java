package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * author xiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("wx/order")
public class WXOrderController {
    @Autowired
    RegionService regionService;

    /*查找省市县 即获取区域列表*/
    @RequestMapping("wx/region/list")
    public ResponseVo regionList(@RequestParam int pid) {
        ResponseVo vo = regionService.findRegionListByPid(pid);
        return vo;
    }

    @Autowired
    BrandService brandService;

    /*品牌列表*/
    @RequestMapping("wx/brand/list")
    public ResponseVo brandList(int page, int size) {
        ResponseVo vo = brandService.findBrandList(page, size);
        return vo;
    }

    /*品牌详情*/
    //"addTime": "2018-01-31 19:00:00", 服务器
    //        "updateTime": "2018-01-31 19:00:00",
    //"addTime": "2018-01-31T16:00:00.000+0000", 本地
    //            "updateTime": "2019-07-05T17:26:13.000+0000",
    //
    @RequestMapping("wx/brand/detail")
    public ResponseVo brandDetial(int id) {
        ResponseVo vo = brandService.findBrandDetail(id);
        return vo;
    }

    /*@RequestMapping("wx/order/submit")
    public ResponseVo orderSubmit(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        ResponseVo vo = brandService.findBrandDetail(id);
        return vo;
    }*/
    //OrderSubmit: WxApiRoot + 'order/submit', // 提交订单
    //OrderPrepay: WxApiRoot + 'order/prepay', // 订单的预支付会话
    //OrderList: WxApiRoot + 'order/list', //订单列表
    //OrderDetail: WxApiRoot + 'order/detail', //订单详情
    //OrderCancel: WxApiRoot + 'order/cancel', //取消订单
    //OrderRefund: WxApiRoot + 'order/refund', //退款取消订单
    //OrderDelete: WxApiRoot + 'order/delete', //删除订单
    //OrderConfirm: WxApiRoot + 'order/confirm', //确认收货
    //OrderGoods: WxApiRoot + 'order/goods', // 代评价商品信息
    //OrderComment: WxApiRoot + 'order/comment', // 评价订单商品信息

    @Autowired
    OrderService orderService;

   /* @RequestMapping("order/list")
    public ResponseVo orderList(int page, int limit, String sort, String order, Integer userId, String orderSn, Integer[] orderStatusArray) {
        ResponseVo vo = orderService.orderList(page, limit, sort, order, userId, orderSn, orderStatusArray);
        return vo;
    }

    @RequestMapping("order/detail")
    public ResponseVo orderDetail(int id) {
        ResponseVo vo = orderService.orderDetail(id);
        return vo;
    }*/

}
