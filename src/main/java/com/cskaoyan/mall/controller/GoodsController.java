package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("goods/list")
    public ResponseVo<DataVo<Goods>> goodsList(int page , int limit , String sort , String order){
        DataVo<Goods> goodsDataVo = goodsService.findGoodsList(page,limit,sort,order);
        ResponseVo<DataVo<Goods>> dataVoResponse = new ResponseVo<DataVo<Goods>>() ;
        dataVoResponse.setErrno(0);
        dataVoResponse.setErrmsg("成功");
        dataVoResponse.setData(goodsDataVo);
        return dataVoResponse;
    }

}
