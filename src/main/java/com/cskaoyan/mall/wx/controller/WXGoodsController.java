package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CreateStorge;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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





}
