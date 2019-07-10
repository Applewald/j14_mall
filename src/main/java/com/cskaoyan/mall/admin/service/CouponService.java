package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.wxhome.CouponList;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 22:11
 */
public interface CouponService {
    PageInfo<Coupon> getAllCoupon(int page, int limit, String name, Short type, Short status, String sort, String order);
    
    int updateById(Coupon coupon);
    
    int deleteById(Coupon coupon);
    
    Coupon readById(int id);
    
    PageInfo<CouponUser> selectByCouponId(int page, int limit, Integer couponId, Integer userId ,Short status,String sort, String order);

    List<CouponList> selectAllCouponList();
    
    PageInfo<Map> getAllCouponBehind(int page, int size);
    
    PageInfo<Map> getMyCoupon(int page, int size, int status,Integer userId);
    
    List<Map> selectlist(int cartId, int grouponRulesId);
    
    int receiveCoupon(Integer couponId,Integer userId);
    
    int exchange(String code, Integer userId);
    
    int insert(Coupon coupon);
}
