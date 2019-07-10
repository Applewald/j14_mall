package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int orderTotal();

    List<Order> orderList(@Param("sort") String sort, @Param("order") String order, @Param("userId") Integer userId, @Param("orderSn") String orderSn, @Param("orderStatusArray") Integer[] orderStatusArray);


    @Select("SELECT count(id) FROM `cskaoyan_mall_order`  where deleted = 0 and user_id = 1 and order_status = 401")
    int findUncommentCounts(@Param("userId") Integer userId);

    @Select("SELECT count(id) FROM `cskaoyan_mall_order`  where deleted = 0 and user_id = 1 and order_status = 102")
    int findUnpaidCounts(@Param("userId") Integer userId);

    @Select("SELECT count(id) FROM `cskaoyan_mall_order`  where deleted = 0 and user_id = 1 and order_status = 301")
    int findUnrecvCounts(@Param("userId") Integer userId);

    @Select("SELECT count(id) FROM `cskaoyan_mall_order`  where deleted = 0 and user_id = 1 and order_status = 201")
    int findUnship(@Param("userId") Integer userId);

    List<Map> findOrderList(@Param("userId") int userId, @Param("showType") int showType);

    Map findOrderDetailById(@Param("orderId") int orderId);

    int orderDeleteById(@Param("orderId") int orderId);

    int orderCancelById(@Param("orderId") int orderId);
}