package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int updateByPrimaryKey(Coupon record);
    
    List<Coupon> getAllCoupon(@Param("name")String name,
                              @Param("type")Short type,
                              @Param("status")Short status,
                              @Param("sort")String sort,
                              @Param("order")String order);
}