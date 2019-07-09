package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.service.StatService;
import com.cskaoyan.mall.admin.bean.statictics.GoodsStat;
import com.cskaoyan.mall.admin.bean.statictics.OrderStat;
import com.cskaoyan.mall.admin.bean.statictics.UserStat;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/4 20:55
 */
@RestController
@RequestMapping("admin")
public class StatisticsController {
    @Autowired
    StatService statService;
    @RequestMapping("stat/user")
    public ResponseVo<Map<String,Object>> user() {
        Map<String,Object> map = new HashMap<>();
        map.put("columns",new String[]{"day","users"});
        List<UserStat> rows = statService.getUserStatList();
        map.put("rows",rows);
        return new ResponseVo(0,map,"成功");

    }

    @RequestMapping("stat/order")
    public ResponseVo<Map<String,Object>> order(){
        Map<String,Object> map = new HashMap<>();
        map.put("columns",new String[]{"day","orders","customers","amount","pcr"});
        List<OrderStat> rows = statService.getOrderStatLIst();
        map.put("rows",rows);
        return new ResponseVo(0,map,"成功");
    }

    @RequestMapping("stat/goods")
     public ResponseVo<Map<String,Object>> goods(){
        Map<String,Object> map = new HashMap<>();
        map.put("columns",new String[]{"day","orders","products","amount"});
        List<GoodsStat> rows = statService.getGoodsStatList();
        map.put("rows",rows);
        return new ResponseVo<>(0,map,"成功");
    }



}
