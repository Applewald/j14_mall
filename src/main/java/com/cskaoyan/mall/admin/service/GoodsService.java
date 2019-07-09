package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.wxhome.GoodsList;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.creategoods.CreateGoods;
import com.cskaoyan.mall.admin.bean.CreateStorge;

import java.util.List;


public interface GoodsService {
    DataVo<Goods> findGoodsList(int page, int limit, String sort, String order, String goodsSn, String name);

    CatAndBrandData findCatAndBrandData();

    boolean goodsCreate(CreateGoods createGoods);

    CreateStorge insertCreategory(CreateStorge createStorge);


    CreateGoods getGoodsDetailsById(int id);

    void updateGoods(CreateGoods createGoods);

    void deleteGoods(Goods goods);

    int goodsTotal();

    int productTotal();

    List<GoodsList> selectAllHotGoodsList();

    List<GoodsList> selectAllNewGoodsList();

    List<Object> selectAllFloorGoodsList();

    List<Object> selectAllGroupOnList();
}
