package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.wxhome.CouponList;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select * from cskaoyan_mall_coupon")
    List<CouponList> selectAllCouponList();
}