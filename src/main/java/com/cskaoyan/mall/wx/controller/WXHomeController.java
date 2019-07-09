package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.promotion.Ad;
import com.cskaoyan.mall.admin.bean.wxhome.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 21:22
 * @description
 */
@RestController
@RequestMapping("/wx/home")
public class WXHomeController {

    @Autowired
    AdService adService;

    @Autowired
    BrandService brandService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    TopicService topicService;

    @Autowired
    CategoryService categoryService;

    /*@Autowired
    GrouponRuleService grouponRuleService;*/

    @Autowired
    CouponService couponService;

    @GetMapping("/index")
    public Object index() {
        List<Ad> ads = adService.selectAllAd();
        List<BrandList> brands = brandService.selectAllBrand();
        List<Channel> channels = categoryService.selectAllChannel();
        List<CouponList> couponLists = couponService.selectAllCouponList();
        List<Object> floorGoodsLists = goodsService.selectAllFloorGoodsList();
        List<Object> grouponLists = goodsService.selectAllGroupOnList();
        List<GoodsList> hotGoodsLists = goodsService.selectAllHotGoodsList();
        List<GoodsList> newGoodsLists = goodsService.selectAllNewGoodsList();
        List<TopicList> topicLists = topicService.selectAllTopicList();

        Map<String, Object> map = new HashMap<>();
        map.put("banner", ads);
        map.put("brandList", brands);
        map.put("channel",channels);
        map.put("couponList", couponLists);
        map.put("floorGoodsList", floorGoodsLists);
        map.put("grouponList", grouponLists);
        map.put("hotGoodsList", hotGoodsLists);
        map.put("newGoodsList", newGoodsLists);
        map.put("topicList", topicLists);

        return ResponseVo.ok(map);

    }
}
