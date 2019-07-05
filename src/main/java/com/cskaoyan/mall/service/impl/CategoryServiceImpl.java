package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.service.CategoryService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        int update = categoryMapper.updateByPrimaryKey(category);
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

}
