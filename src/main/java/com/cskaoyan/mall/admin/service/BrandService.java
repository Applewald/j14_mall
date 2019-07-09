package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface BrandService {

    DataVo<Brand> findBrandList(int page, int limit, Integer id, String name, String sort, String order);

    ResponseVo delete(int id);

    ResponseVo update(Brand brand);

    ResponseVo insert(Brand brand);

    ResponseVo findBrandList(int page, int size);

    ResponseVo findBrandDetail(int id);

}
