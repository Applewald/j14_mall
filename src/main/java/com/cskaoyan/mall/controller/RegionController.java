package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionChildren;
import com.cskaoyan.mall.service.RegionService;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("region")
public class RegionController {
    @Autowired
    RegionService regionService;

    @RequestMapping("list")
    public ResponseVo regionList() {
        ResponseVo<List<RegionChildren>> vo = new ResponseVo<>();
        List<RegionChildren> regionList = regionService.findRegionList();
        vo.setData(regionList);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
}
