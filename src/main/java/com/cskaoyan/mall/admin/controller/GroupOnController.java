package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.promotion.GOListRecord;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import com.cskaoyan.mall.admin.service.GroupOnService;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 20:39
 */
@RestController
@RequestMapping("admin")
public class GroupOnController {
    @Autowired
    GroupOnService groupOnService;
    
    @RequestMapping("groupon/list")
    public ResponseVo<DataVo> list(int page,int limit,Integer goodsId,String sort,String order){
        DataVo<GroupOnRules> dataVo = new DataVo<>();
        PageInfo<GroupOnRules> pageInfo = groupOnService.findGroupOnRules(page,limit,goodsId,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        ResponseVo<DataVo> vo = new ResponseVo<>();
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    @RequestMapping("groupon/update")
    public ResponseVo<GroupOnRules> update(@RequestBody GroupOnRules groupOnRules){
        ResponseVo<GroupOnRules> vo = new ResponseVo<>();
        int i = groupOnService.updateById(groupOnRules);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrmsg("失败");
        }
        return vo;
    }
    
    @RequestMapping("groupon/delete")
    public ResponseVo<GroupOnRules> delete(@RequestBody GroupOnRules groupOnRules){
        ResponseVo<GroupOnRules> vo = new ResponseVo<>();
        int i = groupOnService.deleteByGroupOnRulesId(groupOnRules);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
    
    @RequestMapping("groupon/create")
    public ResponseVo<GroupOnRules> update2(@RequestBody GroupOnRules groupOnRules){
        ResponseVo<GroupOnRules> vo = new ResponseVo<>();
        int i = groupOnService.updateById(groupOnRules);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrmsg("失败");
        }
        return vo;
    }
    
    @RequestMapping("groupon/listRecord")
    public ResponseVo<DataVo> listRecord(int page,int limit,Integer goodsId,String sort,String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<GOListRecord> dataVo = new DataVo<>();
        PageInfo<GOListRecord> pageInfo = groupOnService.findActivity(page,limit,goodsId,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
}
