package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.wx.wxVo.WXPageVo;

/**
 * author : summer
 * date 2019/7/4 20:37
 */
public interface FootprintService {
    ResponseVo<PageVo<Footprint>> list1(int page, int limit, String sort, String order, String userId, String goodsId);

    ResponseVo<WXPageVo<Footprint>> list(int page, int size);
}
