package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.service.CouponService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 22:11
 */
@RestController
public class CouponController {
    @Autowired
    CouponService couponService;
    
    @RequestMapping("coupon/list")
    public ResponseVo<DataVo> list(int page, int limit, String name, Short type, Short status, String sort, String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        if(name == null){
            name = "";
        }
        DataVo<Coupon> dataVo = new DataVo<>();
        PageInfo<Coupon> pageInfo = couponService.getAllCoupon(page,limit,name,type,status,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setErrno(0);
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
}
