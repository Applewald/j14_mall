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

import java.util.ArrayList;
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
        List<Goods> items =  goodsMapper.findGoodList(sort,order,goodsSn,name);
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
        Goods goods1 = goodsMapper.findGoodsByName(goods.getName());

        if (specifications != null && specifications.size() != 0){
            int addsf = goodsMapper.addSpecifications(specifications,goods1.getId());
            System.out.println(specifications.get(0).getId());
        }

        if (products != null && products.size() !=0 ){
            int addProducts = goodsMapper.addProducts(products,goods1.getId());
        }

        if (attributes != null && attributes.size() != 0){
            int addAttributes = goodsMapper.addAttributes(attributes,goods1.getId());
            for (Attribute attribute : attributes){
                System.out.println(attribute.getId());
            }
        }

        return true;
    }


    @Override
    public CreateStorge insertCreategory(CreateStorge createStorge) {
        int id = createStorgeMapper.insertCreategory(createStorge);
        return createStorgeMapper.findCreategoryBy(createStorge.getUrl());
    }



    @Override
    public CreateGoods getGoodsDetailsById(int id) {
        CreateGoods createGoods = new CreateGoods();

        List<Attribute> attributes = goodsMapper.findAttributesByGoodsId(id);
        Goods goods = goodsMapper.findGoodsById(id);

        List<Product> products = goodsMapper.findProductsByGoodsId(id);
        List<Specification> specifications = goodsMapper.findSpecificationsByGoodsId(id);
        int[] categoryIds = new int[2];
        categoryIds[1] = goodsMapper.findGoodsCategoryById(id);
        categoryIds[0] = goodsMapper.findCategoryLv1ByLv2(categoryIds[1]);

        createGoods.setAttributes(attributes);
        createGoods.setGoods(goods);
        createGoods.setProducts(products);
        createGoods.setCategoryIds(categoryIds);
        createGoods.setSpecifications(specifications);

        return createGoods;
    }

    @Override
    @Transactional
    public void deleteGoods(Goods goods) {
        int goodsId = goods.getId();
        goodsMapper.deleteGoodsById(goodsId);
        goodsMapper.deleteAttributesByGoodsId(goodsId);
        goodsMapper.deleteProductsByGoodsId(goodsId);
        goodsMapper.deleteSpecificationsbyGoodsId(goodsId);
    }

    @Override
    @Transactional
    public void updateGoods(CreateGoods createGoods) {

        Goods goods = createGoods.getGoods();
        List<Specification> specifications = createGoods.getSpecifications();
        List<Attribute> attributes = createGoods.getAttributes();
        List<Product> products = createGoods.getProducts();

        Goods checkGoods =  goodsMapper.findGoodsByName(goods.getName());


        int updateGoods =  goodsMapper.updateGoods(goods);

        updateAttributes(attributes,goods.getId());

        updateProducts(products,goods.getId());

        updateSpecifications(specifications,goods.getId());


    }

    private void updateSpecifications(List<Specification> specifications, Integer goodsId) {
        ArrayList idList = new ArrayList();

        for(Specification specification: specifications ){
            int id = specification.getId();
            if (id == 0){
                goodsMapper.addSpecification(specification,goodsId);
            }else {
                idList.add(id);
            }
        }

        if (idList.size() >0){
            int[] ids = new int[idList.size()];
            for (int i = 0 ; i < idList.size() ; i++){
                ids[i] = (int) idList.get(i);
            }

            goodsMapper.deleteSpecificationsNotIn(ids);
        }

    }

    private void updateProducts(List<Product> products, Integer goodsId) {
        ArrayList idList = new ArrayList();

        for(Product product: products ){
            if (product.getAddTime() == null){
                goodsMapper.addProduct(product,goodsId);
            }else {
                idList.add(product.getId());
                goodsMapper.updateProduct(product);
            }
        }
        if (idList.size()>0){
            int[] ids = new int[idList.size()];
            for (int i = 0 ; i < idList.size() ; i++){
                ids[i] = (int) idList.get(i);
            }

            goodsMapper.deleteProductNotIn(ids);
        }





    }

    private void updateAttributes(List<Attribute> attributes, Integer goodsId) {

        ArrayList idList = new ArrayList();

        for(Attribute attribute: attributes ){
            int id = attribute.getId();
            if (id == 0){
                goodsMapper.addAttribute(attribute,goodsId);
            }else {
                idList.add(id);
            }
        }

        if (idList.size() >0){
            int[] ids = new int[idList.size()];
            for (int i = 0 ; i < idList.size() ; i++){
                ids[i] = (int) idList.get(i);
            }

            goodsMapper.deleteAttributesNotIn(ids);
        }


        

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
