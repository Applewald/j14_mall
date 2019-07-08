package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Collect;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/4 20:36
 */
public interface CollectService {
    ResponseVo<PageVo<Collect>> list1(int page, int limit, String sort, String order, String userId, String valueId);
}
