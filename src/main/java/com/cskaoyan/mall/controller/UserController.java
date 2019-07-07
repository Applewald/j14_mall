package com.cskaoyan.mall.controller;


import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.*;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * author : summer
 * date 2019/7/3 20:45
 * 与用户管理相关的controller全部写到一个controller下
 */
@Controller

public class UserController {
    @Autowired
    UserService userService;

    /*@RequestMapping("user/list")
    @ResponseBody
    public ResponseVo<PageVo<User>> list(int page, int limit, String sort,String order) {
        ResponseVo<PageVo<User>> list = userService.list(page, limit, sort, order);
        return list;
    }*/

    @RequestMapping("user/list")
    @ResponseBody
    public ResponseVo<PageVo<User>> userList(int page, int limit, String sort,String order,String username,String mobile) {
        ResponseVo<PageVo<User>> list = userService.list1(page, limit, sort, order,username,mobile);
        return list;
    }

    @Autowired
    AddressService addressService;

    @RequestMapping("address/list")
    @ResponseBody
    public ResponseVo<PageVo<Address>> addressList(int page, int limit, String name, String userId,String sort, String order) {
        ResponseVo<PageVo<Address>> list = addressService.list1(page, limit, sort, order,name,userId);
        return list;
    }

    @Autowired
    CollectService collectService;

    @RequestMapping("collect/list")
    @ResponseBody
    public ResponseVo<PageVo<Collect>> collectList(int page, int limit, String sort, String order, String userId, String valueId) {
        ResponseVo<PageVo<Collect>> list = collectService.list1(page, limit, sort, order,userId,valueId);
        return list;
    }

    @Autowired
    FootprintService footprintService;

    @RequestMapping("footprint/list")
    @ResponseBody
    public ResponseVo<PageVo<Footprint>> footPrintList(int page, int limit, String sort, String order, String userId, String goodsId) {
        ResponseVo<PageVo<Footprint>> list = footprintService.list1(page, limit, sort, order,userId,goodsId);
        return list;
    }

    @Autowired
    SearchHistoryService searchHistoryService;

    @RequestMapping("history/list")
    @ResponseBody
    public ResponseVo<PageVo<SearchHistory>> searchHistoryList(int page, int limit, String sort,String order,String userId,String keyword) {
        ResponseVo<PageVo<SearchHistory>> list = searchHistoryService.list1(page,limit,sort,order,userId,keyword);
        return list;
    }

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("feedback/list")
    @ResponseBody
    public ResponseVo<PageVo<Feedback>> feedbackList(int page, int limit, String sort,String order,String username,String id) {
        ResponseVo<PageVo<Feedback>> list = feedbackService.list1(page, limit, sort, order,username,id);
        return list;
    }

}
