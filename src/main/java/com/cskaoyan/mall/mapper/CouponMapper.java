package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.promotion.Coupon;
import com.cskaoyan.mall.bean.promotion.CouponUser;
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
    
    Coupon selectById(@Param("id")int id);
    
    List<CouponUser> getCouponUserByCouponId(@Param("couponId")Integer couponId,
                                   @Param("userId")Integer userId,
                                   @Param("status")Short status,
                                   @Param("sort")String sort,
                                   @Param("order")String order);
}