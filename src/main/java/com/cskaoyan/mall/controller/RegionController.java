package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
public class RegionController {

    @RequestMapping("region/list")
    public ResponseVo list() {
        ResponseVo<Object> vo = new ResponseVo<>();

        return vo;
    }
}
