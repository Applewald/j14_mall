package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.wxhome.CouponList;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
}
