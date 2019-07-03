package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public DataVo<Goods> findGoodsList(int page, int limit, String sort, String order,String goodsSn) {
        PageHelper.startPage(page,limit);
        List<Goods> items =  goodsMapper.findGoodsList(sort,order,goodsSn);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(items);
        DataVo<Goods> goodsDataVo = new DataVo<Goods>();
        goodsDataVo.setTotal((int)pageInfo.getTotal());
        goodsDataVo.setItems(pageInfo.getList());
        return goodsDataVo;
    }
}
