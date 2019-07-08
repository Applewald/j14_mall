package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.vo.ResponseVo;

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
