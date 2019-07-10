package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import com.cskaoyan.mall.admin.bean.wxhome.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.mapper.CatAndBrandDataMapper;
import com.cskaoyan.mall.admin.mapper.CategoryMapper;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.admin.bean.creategoods.Attribute;
import com.cskaoyan.mall.admin.bean.creategoods.CreateGoods;
import com.cskaoyan.mall.admin.bean.creategoods.Product;
import com.cskaoyan.mall.admin.bean.creategoods.Specification;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.SpecificationVo;
import com.cskaoyan.mall.admin.vo.WxDataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CatAndBrandDataMapper catAndBrandDataMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CreateStorgeMapper createStorgeMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    GroupOnRulesMapper rulesMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    GoodsCommentMapper goodsCommentMapper;

    @Autowired
    IssueMapper issueMapper;


    @Override
    public DataVo<Goods> findGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
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
    public Map<Object, Object> goodsList(Integer categoryId, Integer page, Integer size) {
        Map<Object,Object> data = new HashMap<>();

        PageHelper.startPage(page,size);
        List<GoodsList> goods =  goodsMapper.selectAllGoodsListByCid(categoryId);
        PageInfo<GoodsList> pageInfo = new PageInfo<GoodsList>(goods);

        data.put("count",pageInfo.getTotal());
        data.put("goodsList",pageInfo.getList());

        //不知道filterCategoryList 怎么查的 乱查
        List<Category> filterCategoryList = categoryMapper.findL2CategorysByL1Id(categoryId);
        data.put("filterCategoryList",filterCategoryList);

        return data;
    }

    @Override
    public List<GoodsList> getRelatedGoodsById(Integer id) {
        int categoryId = goodsMapper.findGoodsCategoryById(id);
        List<GoodsList> goodsLists = goodsMapper.selectAllGoodsListByCid(categoryId);
        if (goodsLists.size() > 6){
            List<GoodsList> newList = goodsLists.subList(0,6);
            return newList;
        }else {
            return goodsLists;
        }

    }

    @Override
    public Map<Object, Object> wxGoodsDetailsById(Integer id) {
        Map<Object,Object> data = new HashMap<>();

        Goods info = goodsMapper.findGoodsById(id);
        List<Attribute> attributes =  goodsMapper.findAttributesByGoodsId(id);
        Brand brand = brandMapper.findBrandByBrandId(info.getBrandId()) ;
        List<WxComment> comments = goodsCommentMapper.findGoodsCommentByValueId(id);
        WxDataVo<WxComment> comment;
        if (comments .size() >6){
            comment = new WxDataVo<>((long)6,comments.subList(0,6));
        }
        else {
            comment = new WxDataVo<>((long)comments.size(),comments);
        }

        List<Issue> issue = issueMapper.findAllIssues() ;
        List<Product> productList = goodsMapper.findProductsByGoodsId(id);
        String shareimage = info.getShareUrl();
        List<Specification> specifications = goodsMapper.findSpecificationsByGoodsId(id);

        List<SpecificationVo> specificationList = new ArrayList<>();

        if (specifications == null || specifications.size() == 0){
            specificationList  = null;
        }else {
            HashSet<String> names = new HashSet<>();
            for (int i = 0; i < specifications.size(); i++) {
                names.add(specifications.get(0).getSpecification());
            }

            Object[] nameArray =  names.toArray();
            for (int j = 0 ; j < nameArray.length;j++){
                SpecificationVo specificationVo = new SpecificationVo();
                specificationVo.setName((String) nameArray[j]);
                specificationVo.setValueList(goodsMapper.findSpecificationsByGoodsIdAndSname(id,(String) nameArray[j]));
                specificationList.add(specificationVo);
            }
        }

        //不知道干嘛的
        int userHasCollect = 0;




        data.put("info",info);
        data.put("attributes",attributes);
        data.put("brand",brand);
        data.put("comment",comment);
        data.put("issue",issue);
        data.put("productList",productList);
        data.put("shareimage",shareimage);
        data.put("specificationList",specificationList);
        data.put("userHasCollect",userHasCollect);

        return data;
    }

    @Override
    public int goodsTotal() {
        return goodsMapper.goodsTotal();
    }

    @Override
    public int productTotal() {
        return goodsMapper.productTotal();
    }

    @Override
    public List<GoodsList> selectAllHotGoodsList() {
        List<GoodsList> temp = goodsMapper.selectAllHotGoodsList();
        List<GoodsList> hotGoodsLists = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            hotGoodsLists.add(temp.get(i));
        }
        return hotGoodsLists;
    }

    @Override
    public List<GoodsList> selectAllNewGoodsList() {
        List<GoodsList> temp = goodsMapper.selectAllNewGoodsList();
        List<GoodsList> hotGoodsLists = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            hotGoodsLists.add(temp.get(i));
        }
        return hotGoodsLists;
    }

    @Override
    public List<Object> selectAllFloorGoodsList() {
        ArrayList<Object> mapList = new ArrayList<>();

        List<Channel> channels = categoryService.selectAllChannel();
        for (int i = 0; i < 4; i++) {
            Map<Object, Object> map = new HashMap<>();

            Integer id = channels.get(i).getId();

            List<Category> l2CategorysByL1Id = categoryMapper.findL2CategorysByL1Id(id);

            ArrayList<GoodsList> totalGoodsLists = new ArrayList<>();

            for (Category category : l2CategorysByL1Id) {
                List<GoodsList> goodsLists = goodsMapper.selectAllGoodsListByCid(category.getId());
                totalGoodsLists.addAll(goodsLists);
            }


            map.put("id", channels.get(i).getId());
            map.put("name", channels.get(i).getName());
            if (totalGoodsLists.size() > 5 ) {
                List<GoodsList> goodsLists1 = totalGoodsLists.subList(0, 4);
                map.put("goodsList", goodsLists1);
            } else {
                map.put("goodsList", totalGoodsLists);
            }

            mapList.add(map);
        }

        return mapList;
    }

    @Override
    public List<Object> selectAllGroupOnList() {
        List<Object> list = new ArrayList<>();

        List<GroupOnRules> groupOnRules = rulesMapper.selectAllGroupOnRules();

        for (GroupOnRules groupOnRule : groupOnRules) {
            HashMap<Object, Object> goods = new HashMap<>();
            GroupOnGood groupOnGood = goodsMapper.selectGroupOnGoodByGoodId(groupOnRule.getGoodsId());
            BigDecimal retailPrice = groupOnGood.getRetailPrice();
            BigDecimal discount = groupOnRule.getDiscount();
            BigDecimal subtract = retailPrice.subtract(discount);
            goods.put("goods", groupOnGood);
            goods.put("groupon_member", groupOnRule.getDiscountMember());
            goods.put("groupon_price", subtract);
            list.add(goods);
        }
        return list;
    }

}
