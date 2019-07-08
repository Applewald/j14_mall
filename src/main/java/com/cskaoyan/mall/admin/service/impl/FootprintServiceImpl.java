package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.mapper.FootprintMapper;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PageHelper.startPage(page,limit);
        List<Footprint> users = footprintMapper.queryFootprintByOrder(userId,goodsId,sort,order);
        PageInfo<Footprint> footprintPageInfo = new PageInfo<>(users);

        PageVo<Footprint> userlist= new PageVo<>( (int)footprintPageInfo.getTotal(),footprintPageInfo.getList());

        ResponseVo<PageVo<Footprint>> pageVoResponseVo = new ResponseVo<>();
        if((int)footprintPageInfo.getTotal() > -1) {
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
}
