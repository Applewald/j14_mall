package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;
import com.github.pagehelper.PageInfo;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:25
 */
public interface AdService {
    PageInfo<Ad> getAllAd(int page, int limit, String name,String content,String sort, String order);
    
    int updateByAdId(Ad ad);
    
    int deleteByAdId(Ad ad);
}
