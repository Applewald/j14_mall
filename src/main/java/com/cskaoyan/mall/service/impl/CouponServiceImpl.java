package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.promotion.Coupon;
import com.cskaoyan.mall.bean.promotion.CouponUser;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 22:12
 */
@Service
public class CouponServiceImpl implements CouponService {
    
    @Autowired
    CouponMapper couponMapper;
    
    @Override
    public PageInfo<Coupon> getAllCoupon(int page, int limit, String name, Short type, Short status, String sort, String order) {
        PageHelper.startPage(page,limit);
        if(name == null){
            name = "";
        }
        name = "%" + name + "%";
        List<Coupon> list = couponMapper.getAllCoupon(name,type,status,sort,order);
        PageInfo<Coupon> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public int updateById(Coupon coupon) {
        return couponMapper.updateByPrimaryKey(coupon);
    }
    
    @Override
    public int deleteById(Coupon coupon) {
        Integer id = coupon.getId();
        return couponMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public Coupon readById(int id) {
        return couponMapper.selectById(id);
    }
    
    @Override
    public PageInfo<CouponUser> selectByCouponId(int page, int limit, Integer couponId, Integer userId ,Short status,String sort, String order) {
        PageHelper.startPage(page,limit);
        List<CouponUser> list = couponMapper.getCouponUserByCouponId(couponId,userId,status,sort,order);
        PageInfo<CouponUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
