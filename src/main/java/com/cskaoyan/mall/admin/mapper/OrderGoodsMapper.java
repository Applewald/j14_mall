package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.bean.OrderGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderGoodsMapper {
    long countByExample(OrderGoodsExample example);

    int deleteByExample(OrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsExample example);

    OrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    List<OrderGoods> orderGoods(@Param("orderId") int orderId);

    List<Map> findGoodsList(@Param("orderId") int orderId);

    List<Map> findProductMap(@Param("orderId") int orderId);

    int updateProductNumber(@Param("productId") int productId, @Param("number") int number);

    int deleteOrderGoodsMapper(@Param("orderId") int orderId);
}