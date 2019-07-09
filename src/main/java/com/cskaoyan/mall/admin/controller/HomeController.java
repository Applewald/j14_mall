package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.UserService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.LoginBean;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.TotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 15:32
 * description:
 */
j
@RestController
@RequestMapping("admin")
public class HomeController {

    @RequestMapping("auth/login")
    public ResponseVo login() {
        ResponseVo<String> vo = new ResponseVo<>();
        vo.setErrno(0);
        vo.setData("cc60f91f-bb71-41bb-abcd-76ac976f5378");
        vo.setErrmsg("成功");
        return vo;
    }

    @Autowired
    LoginBean loginBean;

    @RequestMapping("auth/info")
    public ResponseVo info(@RequestParam("token") String token) {
        ResponseVo<LoginBean> vo = new ResponseVo<>();
        vo.setErrno(0);
        vo.setData(loginBean);
        return vo;
    }

    @Autowired
    GoodsService goodsService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @RequestMapping("dashboard")
    public ResponseVo dashboard() {
        TotalVo totalVo = new TotalVo();
        totalVo.setGoodsTotal(goodsService.goodsTotal());
        totalVo.setOrderTotal(orderService.orderTotal());
        totalVo.setProductTotal(goodsService.productTotal());
        totalVo.setUserTotal(userService.userTotal());
        ResponseVo<TotalVo> vo = new ResponseVo<>();
        vo.setErrno(0);
        vo.setData(totalVo);
        vo.setErrmsg("成功");
        return vo;
    }
}
