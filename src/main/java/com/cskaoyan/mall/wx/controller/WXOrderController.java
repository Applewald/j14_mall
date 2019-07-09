package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.util.JacksonUtil;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("wx/brand/detail")
    public ResponseVo brandDetial(int id) {
        ResponseVo vo = brandService.findBrandDetail(id);
        return vo;
    }

    /*提交订单*/
   /* @RequestMapping("wx/order/submit")
    public ResponseVo orderSubmit(@RequestBody String body, HttpServletRequest request) {
        int addressId = JacksonUtil.parseInteger(body, "addressId");
        int cartId = JacksonUtil.parseInteger(body, "cartId");
        int couponId = JacksonUtil.parseInteger(body, "couponId");
        int grouponLinkId = JacksonUtil.parseInteger(body, "grouponLinkId");
        int grouponRulesId = JacksonUtil.parseInteger(body, "grouponRulesId");
        String message = JacksonUtil.parseString(body, "message");

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        ResponseVo vo = orderService.insertOrder(addressId, cartId, couponId, grouponLinkId, grouponRulesId, message);
        return vo;
    }*/

    //OrderPrepay: WxApiRoot + 'order/prepay', // 订单的预支付会话


    //wx/order/list
    /*品牌列表*/
    @RequestMapping("wx/order/list")
    public ResponseVo OrderList(int showType, int page, int size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        ResponseVo vo = orderService.findOrderList(userId, showType, page, size);
        return vo;
    }


    //OrderDetail: WxApiRoot + 'order/detail', //订单详情

    //@RequestMapping("order/detail")

    //OrderCancel: WxApiRoot + 'order/cancel', //取消订单
    //OrderRefund: WxApiRoot + 'order/refund', //退款取消订单
    //OrderDelete: WxApiRoot + 'order/delete', //删除订单
    //OrderConfirm: WxApiRoot + 'order/confirm', //确认收货
    //OrderGoods: WxApiRoot + 'order/goods', // 代评价商品信息
    //OrderComment: WxApiRoot + 'order/comment', // 评价订单商品信息

    @Autowired
    OrderService orderService;


    @RequestMapping("wx/order/detail")
    public ResponseVo orderDetail(int orderId) {
        ResponseVo vo = orderService.orderDetail(orderId);
        return vo;
    }

}
