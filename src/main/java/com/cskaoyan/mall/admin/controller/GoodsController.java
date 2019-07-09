package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.creategoods.CreateGoods;

import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.bean.CreateStorge;
import com.cskaoyan.mall.admin.vo.MessageVo;
import com.cskaoyan.mall.oss.MyOssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("admin")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    MyOssClient myOssClient;



    @RequestMapping("goods/list")

    public ResponseVo<DataVo<Goods>> goodsList(int page , int limit , String sort , String order, String goodsSn, String name){
        DataVo<Goods> goodsDataVo = goodsService.findGoodsList(page,limit,sort,order,goodsSn,name);
        ResponseVo<DataVo<Goods>> dataVoResponse = new ResponseVo<DataVo<Goods>>() ;


        dataVoResponse.setErrno(0);
        dataVoResponse.setErrmsg("成功");
        dataVoResponse.setData(goodsDataVo);
        return dataVoResponse;
    }


    @RequestMapping("goods/catAndBrand")
    public ResponseVo<CatAndBrandData> findCatAndBrand(){
        ResponseVo<CatAndBrandData> catAndBrandDataResponseVo = new ResponseVo<>();
        CatAndBrandData catAndBrandData = goodsService.findCatAndBrandData();

        catAndBrandDataResponseVo.setData(catAndBrandData);
        catAndBrandDataResponseVo.setErrno(0);
        catAndBrandDataResponseVo.setErrmsg("成功");

        return catAndBrandDataResponseVo;
    }

    @RequestMapping("storage/create")
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


    @RequestMapping("goods/create")
    public MessageVo goodsCreate(@RequestBody CreateGoods createGoods){


        boolean create = goodsService.goodsCreate(createGoods);
        if (create == true){
            return  MessageVo.getSuccessMeg();
        }else {
            return MessageVo.getFailMeg();
        }

    }


    @RequestMapping("goods/detail")
    public ResponseVo<CreateGoods> getGoodsDetailsById(int id){
        ResponseVo<CreateGoods> responseVo = new ResponseVo<>();
        CreateGoods createGoods = goodsService.getGoodsDetailsById(id);
        responseVo.setData(createGoods);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    @RequestMapping("goods/update")
    public MessageVo updateGoods(@RequestBody CreateGoods createGoods){

        goodsService.updateGoods(createGoods);

            return MessageVo.getSuccessMeg();
    }


    @RequestMapping("/goods/delete")
    public MessageVo deleteGoods(@RequestBody Goods goods){
        goodsService.deleteGoods(goods);

        return MessageVo.getSuccessMeg();
    }

}
