package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.creategoods.Attribute;
import com.cskaoyan.mall.admin.bean.creategoods.Product;
import com.cskaoyan.mall.admin.bean.creategoods.Specification;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findGoodList(@Param("sort") String sort, @Param("order") String order,@Param("goodsSn") String goodsSn,@Param("name") String name);

    int addGoods( Goods goods);

    int addSpecifications(@Param("specifications") List<Specification> specifications, @Param("goodsId") Integer id);

    int addProducts(@Param("products") List<Product> products, @Param("goodsId") Integer id);


    int addAttributes(@Param("attributes") List<Attribute> attributes, @Param("goodsId") int goodsId);

    int goodsTotal();

    int productTotal();
    Goods findGoodsBypicUrl(@Param("picUrl") String picUrl);

    Goods findGoodsByName(@Param("name") String name);

    List<Attribute> findAttributesByGoodsId(@Param("goodsId") int id);

    Goods findGoodsById(@Param("id") int id);

    List<Product> findProductsByGoodsId(@Param("goodsId") int id);

    List<Specification> findSpecificationsByGoodsId(@Param("goodsId") int id);

    int findGoodsCategoryById(@Param("id") int id);

    int findCategoryLv1ByLv2(@Param("Lv2Id") int categoryId);

    int updateGoods(Goods goods);

    void addAttribute(@Param("a") Attribute attribute,@Param("goodsId") int goodsId);

    void deleteAttributesNotIn(@Param("ids") int[] ids);

    void addSpecification(@Param("s") Specification specification, @Param("goodsId") Integer goodsId);

    void deleteSpecificationsNotIn(@Param("ids") int[] ids);

    void addProduct(@Param("p") Product product,@Param("goodsId") Integer goodsId);

    void updateProduct(@Param("p") Product product);

    void deleteProductNotIn(@Param("ids") int[] ids);

    void deleteGoodsById(@Param("goodsId") int goodsId);

    void deleteAttributesByGoodsId(@Param("goodsId") int goodsId);

    void deleteProductsByGoodsId(@Param("goodsId") int goodsId);

    void deleteSpecificationsbyGoodsId(@Param("goodsId") int goodsId);
}

