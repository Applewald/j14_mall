package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findGoodsList(@Param("sort") String sort, @Param("order") String order,@Param("goodsSn") String goodsSn);

    int addGoods( Goods goods);
}
