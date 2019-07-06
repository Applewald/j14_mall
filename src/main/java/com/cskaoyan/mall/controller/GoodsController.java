package com.cskaoyan.mall.controller;


import com.cskaoyan.mall.bean.catandbrand.CatAndBrandData;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.creategoods.CreateGoods;

import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.bean.CreateStorge;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.MessageVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.cskaoyan.mall.oss.MyOssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    MyOssClient myOssClient;



    @RequestMapping("goods/list")
    public ResponseVo<DataVo<Goods>> goodsList(int page , int limit , String sort , String order,String goodsSn,String name){
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
        ResponseVo<CreateStorge> responseVo = new ResponseVo<>();

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


}
