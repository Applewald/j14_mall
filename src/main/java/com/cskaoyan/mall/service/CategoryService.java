package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface CategoryService {

    ResponseVo findCategoryList();

    ResponseVo findCategoryL1();

    ResponseVo delete(int id);

    ResponseVo update(Category category);

    ResponseVo insert(Category category);

}
