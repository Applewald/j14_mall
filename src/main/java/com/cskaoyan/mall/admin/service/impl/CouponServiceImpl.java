package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.wxhome.CouponList;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import com.cskaoyan.mall.admin.mapper.CouponMapper;
import com.cskaoyan.mall.admin.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<CouponList> selectAllCouponList() {
        return couponMapper.selectAllCouponList();
    }
    
    @Override
    public PageInfo<Map> getAllCouponBehind(int page, int size) {
        PageHelper.startPage(page,size);
        List<Map> list = couponMapper.getCoupons();
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public PageInfo<Map> getMyCoupon(int page, int size, int status,Integer userId) {
        PageHelper.startPage(page,size);
        List<Map> list = couponMapper.getMyCoupons(status,userId);
        System.out.println(userId);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public List<Map> selectlist(int cartId, int grouponRulesId) {
        return couponMapper.selectlist(cartId,grouponRulesId);
    }
    
    @Override
    public int receiveCoupon(Integer couponId,Integer userId) {
        return couponMapper.insertByUserId(userId,couponId);
    }
    
    @Override
    public int exchange(String code, Integer userId) {
        Coupon coupon = couponMapper.selectCouponByCode(code);
        if(coupon != null){
            return couponMapper.insertByUserId2(userId,code);
        } else {
            return 0;
        }
    }
    
    @Override
    public int insert(Coupon coupon) {
        return couponMapper.insert(coupon);
    }
}
