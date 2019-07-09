package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.GroupOn;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.service.GroupOnService;
import com.cskaoyan.mall.admin.util.OrderStatusUtil;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResponseVo orderList(int page, int limit, String sort, String order, Integer userId, String orderSn, Integer[] orderStatusArray) {
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<Order> orderDataVo = new DataVo<>();
        PageHelper.startPage(page, limit);
        List<Order> orderList=orderMapper.orderList(sort,order,userId,orderSn,orderStatusArray);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        orderDataVo.setTotal(pageInfo.getTotal());
        orderDataVo.setItems(pageInfo.getList());
        vo.setErrmsg("成功");
        vo.setData(orderDataVo);
        vo.setErrno(0);
        return vo;
    }

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Override
    public ResponseVo orderDetail(int id) {
        ResponseVo vo = new ResponseVo();
        Order order = orderMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(order.getUserId());
        List<OrderGoods> orderGoods = orderGoodsMapper.orderGoods(order.getId());
        /*for (OrderGoods orderGood : orderGoods) {
            orderGood.getProductId()
        }*/
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("order", order);
        map.put("user", user);
        map.put("orderGoods", orderGoods);

        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }


    @Override
    public Map<Object, Object> findOrderStatusByUserId(Integer userId) {

        Map<Object, Object> data = new HashMap<>();
        int uncomment = orderMapper.findUncommentCounts(userId);
        int unpaid = orderMapper.findUnpaidCounts(userId);
        int unrecv = orderMapper.findUnrecvCounts(userId);
        int unship = orderMapper.findUnship(userId);

        data.put("uncomment", uncomment);
        data.put("unpaid", unpaid);
        data.put("unrecv", unrecv);
        data.put("unship", unship);

        return data;
    }

    @Autowired
    CartMapper cartMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    GroupOnMapper groupOnMapper;
    @Autowired
    GroupOnRulesMapper groupOnRulesMapper;
    @Override
    public ResponseVo insertOrder(int addressId, int cartId, int couponId, int grouponLinkId, int grouponRulesId, String message) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        Cart cart = cartMapper.selectByPrimaryKey(cartId);
        Coupon coupon = couponMapper.selectById(couponId);
        GroupOn groupOn = groupOnMapper.selectByPrimaryKey(grouponLinkId);
        GroupOnRules groupOnRules = groupOnRulesMapper.selectByPrimaryKey(grouponRulesId);
        return null;
    }

    @Autowired
    HandleOption handleOption;
    @Override
    public ResponseVo findOrderList(int userId, int showType, int page, int size) {
        Map map = new HashMap();
        PageHelper.startPage(page, size);
        ResponseVo<Object> vo = new ResponseVo<>();
        List<Map> data = orderMapper.findOrderList(userId, showType);
        for (Map datum : data) {
            //判断订单的状态
            int orderStatus = ((int) datum.get("orderStatusText"));
            String orderStatusText = OrderStatusUtil.toOrderStatusText(orderStatus);
            datum.put("orderStatusText", orderStatusText);
            //判断是否用了优惠券
            BigDecimal grouponPrice = (BigDecimal) datum.get("isGroupin");
            if (grouponPrice.compareTo(new BigDecimal(0))<=0) {
                datum.put("isGroupin", false);
            }else {
                datum.put("isGroupin", true);
            }
            int orderId = ((int) datum.get("id"));
            List<Map> goodsList = orderGoodsMapper.findGoodsList(orderId);
            datum.put("goodsList", goodsList);
            //订单已评价
            int comments = ((int) datum.get("comments"));
            if (comments <= 0) {
                handleOption.setComment(true);
            }
            datum.remove("comments");
            handleOption = OrderStatusUtil.getHandleOption(orderStatus, handleOption);
            datum.put("handleOption", handleOption);
        }
        PageInfo pageInfo = new PageInfo(data);
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());
        map.put("totalPages", pageInfo.getPages());
        vo.setData(map);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
}
