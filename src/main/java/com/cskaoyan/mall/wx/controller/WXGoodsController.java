package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CreateStorge;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.wxhome.GoodsList;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.BaseRespVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iwppa
 * @version 1.0
 * @date 2019/7/9 11:17
 */

@RestController
@RequestMapping("/wx")
public class WXGoodsController {

    @Autowired
    com.cskaoyan.mall.oss.MyOssClient myOssClient;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("storage/upload")
    public ResponseVo<CreateStorge> createStorage(MultipartFile file){
        CreateStorge createStorge = new CreateStorge();
        ResponseVo<CreateStorge> responseVo = new ResponseVo<CreateStorge>();

        try {
            createStorge = myOssClient.ossFileUpload(file);
            CreateStorge createStorge1 = goodsService.insertCreategory(createStorge);
            responseVo.setData(createStorge1);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);

        } catch (IOException e) {
            e.printStackTrace();
            responseVo.setErrmsg("失败");
            responseVo.setErrno(-1);
            return responseVo;
        }
        return responseVo;
    }



    @RequestMapping("goods/count")
    public BaseRespVo countGoods(){
        int goodsCount = goodsService.goodsTotal();
        Map<Object,Object> data = new HashMap<>();
        data.put("goodsCount",goodsCount);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("catalog/index")
    public BaseRespVo QueryCategoryList(){
        Map<Object,Object> data = new HashMap<>();
        data = categoryService.findCategoryGoods();
        return BaseRespVo.ok(data);
    }


    @RequestMapping("catalog/current")
    public BaseRespVo QueryCurrentCategory(Integer id){
        Map<Object,Object> data = new HashMap<>();
        data = categoryService.QueryCurrentCategory(id);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("goods/category")
    public BaseRespVo goodsCategory(Integer id){
        Map<Object,Object> data = new HashMap<>();
        data = categoryService.goodsCategory(id);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("goods/list")
    public BaseRespVo goodsList(Integer categoryId,Integer page,Integer size){
        Map<Object,Object> data = new HashMap<>();
        data = goodsService.goodsList(categoryId,page,size);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("goods/detail")
    public BaseRespVo goodsDetail (Integer id){
        Map<Object,Object> data = new HashMap<>();
        data = goodsService.wxGoodsDetailsById(id);
        return BaseRespVo.ok(data);
    }

    @RequestMapping("goods/related")
    public BaseRespVo goodsRelated(Integer id){
        List<GoodsList>  goodsLists = goodsService.getRelatedGoodsById(id);
        return BaseRespVo.ok(goodsLists);
    }

    //@RequestMapping

}
