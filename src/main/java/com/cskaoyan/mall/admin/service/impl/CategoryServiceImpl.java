package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.mapper.CategoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseVo findCategoryList() {
        List<Category> items = categoryMapper.findCategoryList();
        ResponseVo<List<Category>> vo = new ResponseVo<>();
        vo.setData(items);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }

    @Override
    public ResponseVo findCategoryL1() {
        List<Category> items = categoryMapper.findCategoryL1();
        ResponseVo<List<Category>> vo = new ResponseVo<>();
        vo.setData(items);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }

    @Override
    public ResponseVo delete(int id) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int delete = categoryMapper.deleteByPrimaryKey(id);
        if (delete == 1) {
            vo.setErrno(0);
            vo.setErrmsg("成功");
        } else {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }

    @Override
    public ResponseVo update(Category category) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int update;
        //一级类目
        if (category.getPid() == null) {
            update = categoryMapper.update1ByPrimaryKey(category);
        }else {
            //二级类目
            update = categoryMapper.update2ByPrimaryKey(category);
        }
        if (update == 1) {
            vo.setErrno(0);
            vo.setErrmsg("成功");
        } else {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }

    @Override
    public ResponseVo insert(Category category) {
        ResponseVo<Object> vo = new ResponseVo<>();
        if (category.getDeleted() == null) {
            category.setDeleted(false);
        }
        if (category.getSortOrder() == null) {
            category.setSortOrder((byte) 0);
        }
        try {
            int insert = categoryMapper.insert(category);
            if (insert == 1) {
                vo.setErrno(0);
                vo.setErrmsg("成功");
            }
        } catch (Exception e) {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }


    @Override
    public Map<Object, Object> findCategoryGoods() {
        Map<Object,Object> data = new HashMap<>();

        List<Category> categoryList = categoryMapper.findL1CategoryList();
        data.put("categoryList",categoryList);
        if (categoryList == null || categoryList.size() == 0){
            data.put("currentCategory",null);
            data.put("currentSubCategory",null);
        }else {

            Category currentCategory = categoryList.get(0);
            data.put("currentCategory",currentCategory);

            List<Category> currentSubCategory = categoryMapper.findL2CategorysByL1Id(currentCategory.getId());
            data.put("currentSubCategory",currentSubCategory);
        }
        return data;
    }


    @Override
    public Map<Object, Object> QueryCurrentCategory(Integer currentId) {
        Map<Object,Object> data = new HashMap<>();
        Category currentCategory = categoryMapper.findCategoryById(currentId);
        List<Category> currentSubCategory = categoryMapper.findL2CategorysByL1Id(currentId);
        data.put("currentCategory",currentCategory);
        data.put("currentSubCategory",currentSubCategory);
        return data;
    }


    @Override
    public Map<Object, Object> goodsCategory(Integer id) {

        Map<Object,Object> data = new HashMap<>();

        //当前分类
        Category currentCategory = categoryMapper.findCategoryById(id);
        //父分类
        Category parentCategory = categoryMapper.findCategoryById(currentCategory.getPid());
        //同级分类，包括自己
        List<Category> brotherCategory = categoryMapper.findL2CategorysByL1Id(currentCategory.getPid());
        //删除当前分类
        boolean remove = brotherCategory.remove(currentCategory);

        data.put("currentCategory",currentCategory);
        data.put("parentCategory",parentCategory);
        data.put("brotherCategory",brotherCategory);

        return data;

    }
}
