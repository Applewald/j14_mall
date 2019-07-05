package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.RegionChildren;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;

import java.util.List;

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

}
