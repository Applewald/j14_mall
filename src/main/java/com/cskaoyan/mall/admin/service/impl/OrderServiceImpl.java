package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.admin.mapper.OrderMapper;
import com.cskaoyan.mall.admin.mapper.UserMapper;
import com.cskaoyan.mall.admin.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
}
