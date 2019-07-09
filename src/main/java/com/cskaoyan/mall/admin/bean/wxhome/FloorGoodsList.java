package com.cskaoyan.mall.admin.bean.wxhome;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-09 10:17
 * @description
 */
public class FloorGoodsList {

    Integer id;

    String name;

    List<GoodsList> goodsLists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsList> getGoodsLists() {
        return goodsLists;
    }

    public void setGoodsLists(List<GoodsList> goodsLists) {
        this.goodsLists = goodsLists;
    }
}
