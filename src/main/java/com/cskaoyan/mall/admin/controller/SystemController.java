package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.MallSystem;
import com.cskaoyan.mall.admin.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/4 9:18
 */
@RestController
@RequestMapping("admin")
public class SystemController {
    @Autowired
    SystemService systemService;

//1商场配置
    @GetMapping("config/mall")
    public ResponseVo findMallConfig(){

            return findMall("cskaoyan_mall_mall");
        }

    @PostMapping("config/mall")
    public ResponseVo updateMall(@RequestBody Map<String, String> systemMap){
        return certain(systemMap);
    }
//2运费配置
    @GetMapping("config/express")
    public ResponseVo findFreightConfig(){
        return findMall("cskaoyan_mall_express");
    }
    @PostMapping("config/express")
    public ResponseVo updateFreight(@RequestBody Map<String, String> systemMap){
        return certain(systemMap);
    }
//3订单配置
    @GetMapping("config/order")
    public ResponseVo findOrderConfig(){
        return findMall("cskaoyan_mall_order");
    }
    @PostMapping("config/order")
    public ResponseVo updateOrder(@RequestBody Map<String, String> systemMap){
        return certain(systemMap);
    }
//4小程序配置config/wx
    @GetMapping("config/wx")
    public ResponseVo findWxConfig(){
        return findMall("cskaoyan_mall_wx");
    }
    @PostMapping("config/wx")
    public ResponseVo updateWx(@RequestBody Map<String, String> systemMap){
        return certain(systemMap);
    }





    public ResponseVo findMall(String prefix){
        Map<String, String> systemMap = new HashMap<>();
        List<MallSystem> mall = systemService.selectMallSystemByPrefix(prefix);
        for (MallSystem mallSystem : mall) {
            systemMap.put(mallSystem.getKeyName(), mallSystem.getKeyValue());
        }
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(systemMap);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    public ResponseVo certain(Map<String, String> systemMap){
        boolean b = systemService.updateMallSystemBykeyName(systemMap);
        ResponseVo responseVo = new ResponseVo();
        if (b){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("修改失败！");
            responseVo.setErrno(500);
        }
        return responseVo;
    }




}
