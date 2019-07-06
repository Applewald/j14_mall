package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.service.BrandService;
import com.cskaoyan.mall.service.BrandService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    BrandMapper brandMapper;

    @Override
    public DataVo<Brand> findBrandList(int page, int limit, Integer id, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        if ("".equals(id)) {
            id = null;
        }
        if ("".equals(name)) {
            name = null;
        }
        List<Brand> items = brandMapper.findBrandList(id, name, sort, order);
        PageInfo<Brand> pageInfo = new PageInfo<>(items);
        DataVo<Brand> brandDataVo = new DataVo<>();
        brandDataVo.setTotal(pageInfo.getTotal());
        brandDataVo.setItems(pageInfo.getList());
        return brandDataVo;
    }

    @Override
    public ResponseVo delete(int id) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int delete = brandMapper.deleteByPrimaryKey(id);
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
    public ResponseVo update(Brand brand) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int update = brandMapper.updateByPrimaryKey(brand);
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
    public ResponseVo insert(Brand brand) {
        ResponseVo<Object> vo = new ResponseVo<>();
        if (brand.getDeleted() == null) {
            brand.setDeleted(false);
        }
        if (brand.getSortOrder() == null) {
            brand.setSortOrder((byte) 0);
        }
        try {
            int insert = brandMapper.insert(brand);
            if (insert == 1) {
                vo.setErrno(0);
                vo.setErrmsg("成功");
            }
        } catch (Exception e) {
            vo.setErrno(-1);
            vo.setErrmsg("添加品牌商失败");
        }
        return vo;
    }

}
