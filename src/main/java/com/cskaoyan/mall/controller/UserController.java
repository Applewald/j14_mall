package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * author : summer
 * date 2019/7/3 20:45
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<PageVo<User>> list(int page, int limit, String sort,String order) {
        ResponseVo<PageVo<User>> list = userService.list(page, limit, sort, order);
        return list;
    }


}
