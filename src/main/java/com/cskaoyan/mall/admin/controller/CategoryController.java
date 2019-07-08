package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("list")
    public ResponseVo categoryList() {
        ResponseVo vo = categoryService.findCategoryList();
        return vo;
    }

    @RequestMapping("delete")
    public ResponseVo categoryDelete(@RequestBody Category category) {
        ResponseVo<String> vo = categoryService.delete(category.getId());
        return vo;
    }

    @RequestMapping("update")
    public ResponseVo categoryUpdate(@RequestBody Category category) {
        ResponseVo<String> vo = categoryService.update(category);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVo categoryCreate(@RequestBody Category category) {
        ResponseVo<String> vo = categoryService.insert(category);
        return vo;
    }

    @RequestMapping("l1")
    public ResponseVo categoryL1() {
        ResponseVo vo = categoryService.findCategoryL1();
        return vo;
    }
}
