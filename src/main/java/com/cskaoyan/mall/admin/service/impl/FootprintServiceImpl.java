package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.mapper.FootprintMapper;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.wx.wxVo.WXPageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : summer
 * date 2019/7/3 20:57
 */
@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    FootprintMapper footprintMapper;


    @Override
    public ResponseVo<PageVo<Footprint>> list1(int page, int limit, String sort, String order, String userId, String goodsId) {
        PageHelper.startPage(page, limit);
        List<Footprint> users = footprintMapper.queryFootprintByOrder(userId, goodsId, sort, order);
        PageInfo<Footprint> footprintPageInfo = new PageInfo<>(users);

        PageVo<Footprint> userlist = new PageVo<>((int) footprintPageInfo.getTotal(), footprintPageInfo.getList());

        ResponseVo<PageVo<Footprint>> pageVoResponseVo = new ResponseVo<>();
        if ((int) footprintPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(userlist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }

    /*@Override
    public ResponseVo<WXPageVo<Footprint> > list(int page, int size) {
        PageHelper.startPage(page, size);
        List<Footprint> list1 = footprintMapper.queryFootprints();
        PageInfo<Footprint> pageInfo = new PageInfo<>(list1);
        WXPageVo<Footprint> footList = new WXPageVo<Footprint>((int)pageInfo.getTotal(),pageInfo.getList());
        ResponseVo<WXPageVo<Footprint>> footResponseVo = new ResponseVo<>();
        if((int)pageInfo.getTotal() > -1) {
            footResponseVo.setData(footList);
            footResponseVo.setErrmsg("成功");
            footResponseVo.setErrno(0);
        } else {
            footResponseVo.setData(null);
            footResponseVo.setErrmsg("系统内部错误");
            footResponseVo.setErrno(502);
        }
        return footResponseVo;
    }
*/

    @Override
    public ResponseVo findFootPrintList(int page, int size) {
        PageHelper.startPage(page, size);
        List<Map> footprintList = footprintMapper.queryFootprints();
        PageInfo<Map> mapPageInfo = new PageInfo<>(footprintList);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("footprintList",footprintList);
        hashMap.put("totalPages",mapPageInfo.getTotal());
        ResponseVo<Object> vo = new ResponseVo<>();
        if(mapPageInfo.getTotal() > -1) {
            vo.setData(hashMap);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setData(null);
            vo.setErrmsg("系统内部错误");
            vo.setErrno(502);
        }
        return vo;
    }
}