package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.GoodsComment;
import com.cskaoyan.mall.admin.bean.promotion.Ad;
import com.cskaoyan.mall.admin.bean.wxhome.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/wx")
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

    @Autowired
    CouponService couponService;

    @Autowired
    GoodsCommentService goodsCommentService;

    @GetMapping("/home/index")
    public Object homeIndex() {
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


    @GetMapping("/comment/list")
    public Object commentList(Integer valueId, Integer type, Integer size, Integer page, Integer showType) {
        HashMap<Object, Object> map = new HashMap<>();
        List<Object> list = goodsCommentService.selectAllCommentsList(valueId, type, size, page, showType);
        map.put("count", list.size());
        map.put("currentPage", page);
        map.put("data", list);

        return ResponseVo.ok(map);
    }

    @PostMapping("/comment/post")
    public Object commentPost(Integer userId, @RequestBody GoodsComment comment) {
        if (userId == null) {
            return ResponseVo.fail("请登录", -1);
        }

        comment.setUserId(userId);
        goodsCommentService.insert(comment);
        return ResponseVo.ok(comment);

    }
}
