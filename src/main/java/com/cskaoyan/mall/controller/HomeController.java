package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.LoginBean;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 15:32
 * description:
 */
@RestController
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
}
