package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.creategoods.Attribute;
import com.cskaoyan.mall.bean.creategoods.Product;
import com.cskaoyan.mall.bean.creategoods.Specification;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findGoodsList(@Param("sort") String sort, @Param("order") String order,@Param("goodsSn") String goodsSn);

    int addGoods( Goods goods);

    int addSpecifications(@Param("specifications") List<Specification> specifications, @Param("goodsId") Integer id);

    int addProducts(@Param("products") List<Product> products, @Param("goodsId") Integer id);


    int addAttributes(@Param("attributes") List<Attribute> attributes, @Param("goodsId") int goodsId);

    int goodsTotal();

    int productTotal();
}
