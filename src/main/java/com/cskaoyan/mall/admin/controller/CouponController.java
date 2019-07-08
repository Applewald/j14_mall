package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.promotion.Coupon;
import com.cskaoyan.mall.admin.bean.promotion.CouponUser;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 22:11
 */
@RestController
@RequestMapping("admin")
public class CouponController {
    @Autowired
    CouponService couponService;
    
    @RequestMapping("coupon/list")
    public ResponseVo<DataVo> list(int page, int limit, String name, Short type, Short status, String sort, String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<Coupon> dataVo = new DataVo<>();
        PageInfo<Coupon> pageInfo = couponService.getAllCoupon(page,limit,name,type,status,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setErrno(0);
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
    
    @RequestMapping("coupon/update")
    public ResponseVo<Coupon> update(@RequestBody Coupon coupon){
        ResponseVo<Coupon> vo = new ResponseVo<>();
        int i = couponService.updateById(coupon);
        vo.setData(coupon);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrno(500);
            vo.setErrmsg("失败");
        }
        return vo;
    }
    
    @RequestMapping("coupon/delete")
    public ResponseVo<Coupon> delete(@RequestBody Coupon coupon){
        ResponseVo<Coupon> vo = new ResponseVo<>();
        int i = couponService.deleteById(coupon);
        vo.setData(coupon);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
    
    @RequestMapping("coupon/read")
    public ResponseVo<Coupon> read(int id){
        ResponseVo<Coupon> vo = new ResponseVo<>();
        Coupon coupon = couponService.readById(id);
        vo.setData(coupon);
        if(coupon != null){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
    
    @RequestMapping("coupon/listuser")
    public ResponseVo<DataVo> listUser(int page,int limit ,Integer couponId,Integer userId ,Short status,String sort,String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<CouponUser> dataVo = new DataVo<>();
        PageInfo<CouponUser> pageInfo = couponService.selectByCouponId(page,limit,couponId,userId,status,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setErrno(0);
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
}
