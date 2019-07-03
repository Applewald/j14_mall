package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.vo.DataVo;

public interface GoodsService {
    DataVo<Goods> findGoodsList(int page, int limit, String sort, String order);
}
