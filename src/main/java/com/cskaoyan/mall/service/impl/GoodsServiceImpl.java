package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.creategoods.Attribute;
import com.cskaoyan.mall.bean.creategoods.CreateGoods;
import com.cskaoyan.mall.bean.creategoods.Product;
import com.cskaoyan.mall.bean.creategoods.Specification;
import com.cskaoyan.mall.mapper.CatAndBrandDataMapper;
import com.cskaoyan.mall.mapper.CreateStorgeMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.bean.CreateStorge;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CatAndBrandDataMapper catAndBrandDataMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CreateStorgeMapper createStorgeMapper;

    @Override
    public DataVo<Goods> findGoodsList(int page, int limit, String sort, String order,String goodsSn,String name) {
        PageHelper.startPage(page,limit);
        List<Goods> items =  goodsMapper.findGoodsList(sort,order,goodsSn,name);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(items);
        DataVo<Goods> goodsDataVo = new DataVo<Goods>();
        goodsDataVo.setTotal(pageInfo.getTotal());
        goodsDataVo.setItems(pageInfo.getList());
        return goodsDataVo;
    }


    @Override
    public CatAndBrandData findCatAndBrandData() {
        CatAndBrandData catAndBrandData = new CatAndBrandData();
        catAndBrandData.setBrandList(catAndBrandDataMapper.findBrandList());
        catAndBrandData.setCategoryList(catAndBrandDataMapper.findCategoryList());
        return catAndBrandData;
    }


    @Override
    @Transactional
    public boolean goodsCreate(CreateGoods createGoods) {


        Goods goods = createGoods.getGoods();
        List<Specification> specifications = createGoods.getSpecifications();
        List<Attribute> attributes = createGoods.getAttributes();
        List<Product> products = createGoods.getProducts();

        Goods checkGoods =  goodsMapper.findGoodsByName(goods.getName());

        if (checkGoods != null){
            return false;
        }

        int add = goodsMapper.addGoods(goods);
        Goods goods1 = goodsMapper.findGoodsBypicUrl(goods.getPicUrl());

        if (specifications != null && specifications.size() != 0){
            int addsf = goodsMapper.addSpecifications(specifications,goods1.getId());
        }

        if (products != null && products.size() !=0 ){
            int addProducts = goodsMapper.addProducts(products,goods1.getId());
        }

        if (attributes != null && attributes.size() != 0){
            int addAttributes = goodsMapper.addAttributes(attributes,goods1.getId());
        }


        return true;
    }


    @Override
    public CreateStorge insertCreategory(CreateStorge createStorge) {
        int id = createStorgeMapper.insertCreategory(createStorge);
        return createStorgeMapper.findCreategoryBy(createStorge.getUrl());
    }

    @Override
    public int goodsTotal() {
        return goodsMapper.goodsTotal();
    }

    @Override
    public int productTotal() {
        return goodsMapper.productTotal();
    }
}
