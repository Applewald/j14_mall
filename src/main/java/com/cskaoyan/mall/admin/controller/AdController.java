package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.promotion.Ad;
import com.cskaoyan.mall.admin.service.AdService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 9:30
 */
@RestController
@RequestMapping("admin")
public class AdController {
    
    @Autowired
    AdService adService;
    
    @RequestMapping("ad/list")
    public ResponseVo<DataVo> list(int page, int limit, String name, String content, String sort, String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<Ad> dataVo = new DataVo<>();
        PageInfo<Ad> pageInfo = adService.getAllAd(page,limit,name,content,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setErrno(0);
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
    
    @RequestMapping("ad/update")
    public ResponseVo<Ad> update(@RequestBody Ad ad){
        ResponseVo<Ad> vo = new ResponseVo<>();
        int i = adService.updateByAdId(ad);
        vo.setData(ad);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrno(500);
            vo.setErrmsg("失败");
        }
        return vo;
    }
    
    @RequestMapping("ad/delete")
    public ResponseVo<Ad> delete(@RequestBody Ad ad){
        ResponseVo<Ad> vo = new ResponseVo<>();
        int i = adService.deleteByAdId(ad);
        vo.setData(ad);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
    
    @RequestMapping("ad/create")
    public ResponseVo<Map> create(@RequestBody Map<Object,Object> ad){
        ResponseVo<Map> vo = new ResponseVo<>();
        int i = adService.insert(ad);
        vo.setData(ad);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
}
