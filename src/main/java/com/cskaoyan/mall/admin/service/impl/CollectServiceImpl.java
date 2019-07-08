package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Collect;
import com.cskaoyan.mall.admin.mapper.CollectMapper;
import com.cskaoyan.mall.admin.service.CollectService;
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
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;


    @Override
    public ResponseVo<PageVo<Collect>> list1(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page,limit);
        List<Collect> collects = collectMapper.queryCollectByOrder(userId,valueId,sort,order);
        PageInfo<Collect> collectPageInfo = new PageInfo<>(collects);

        PageVo<Collect> collectlist= new PageVo<>( (int)collectPageInfo.getTotal(),collectPageInfo.getList());

        ResponseVo<PageVo<Collect>> pageVoResponseVo = new ResponseVo<>();
        if((int)collectPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(collectlist);
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
