package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Coupon;
import com.github.pagehelper.PageInfo;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 22:11
 */
public interface CouponService {
    PageInfo<Coupon> getAllCoupon(int page, int limit, String name, Short type, Short status, String sort, String order);
}
