package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.GoodsComment;
import com.cskaoyan.mall.mapper.GoodsCommentMapper;
import com.cskaoyan.mall.service.GoodsCommentService;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    GoodsCommentMapper goodsCommentMapper;

    @Override
    public DataVo<GoodsComment> findGoodsComments(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page,limit);
        List<GoodsComment> items =  goodsCommentMapper.findComments(sort,order,userId,valueId);
        PageInfo<GoodsComment> pageInfo = new PageInfo<>(items);
        DataVo<GoodsComment> goodsCommentDataVo = new DataVo<>();
        goodsCommentDataVo.setTotal(pageInfo.getTotal());
        goodsCommentDataVo.setItems(pageInfo.getList());
        return goodsCommentDataVo;

    }
}
