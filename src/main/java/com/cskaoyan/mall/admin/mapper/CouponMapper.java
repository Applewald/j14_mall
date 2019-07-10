package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import com.cskaoyan.mall.admin.bean.wxhome.CouponList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
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
    
    List<Map> getCoupons();
    
    List<Map> getMyCoupons(@Param("status")int status, @Param("userId")Integer userId);
    
    List<Map> selectlist(@Param("cartId")int cartId, @Param("rulesId")int grouponRulesId);
    
    int insertByUserId(@Param("userId")Integer userId, @Param("couponId")Integer couponId);
    
    int insertByUserId2(@Param("userId")Integer userId, @Param("code")String code);
    
    Coupon selectCouponByCode(@Param("code")String code);
}