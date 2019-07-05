package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.creategoods.CreateGoods;
import com.cskaoyan.mall.bean.CreateStorge;
import com.cskaoyan.mall.vo.DataVo;

public interface GoodsService {
    DataVo<Goods> findGoodsList(int page, int limit, String sort, String order,String goodsSn);

    CatAndBrandData findCatAndBrandData();

    void goodsCreate(CreateGoods createGoods);

    CreateStorge insertCreategory(CreateStorge createStorge);

    int goodsTotal();

    int productTotal();
}
