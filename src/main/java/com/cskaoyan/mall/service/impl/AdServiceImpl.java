package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:25
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;
    
    @Override
    public PageInfo<Ad> getAllAd(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Ad> list = adMapper.getAllAd(sort,order);
        PageInfo<Ad> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public int updateByAdId(Ad ad) {
        return adMapper.updateById(ad);
    }
}
