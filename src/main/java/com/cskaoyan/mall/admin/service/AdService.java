package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.promotion.Ad;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:25
 */
public interface AdService {
    PageInfo<Ad> getAllAd(int page, int limit, String name,String content,String sort, String order);
    
    int updateByAdId(Ad ad);
    
    int deleteByAdId(Ad ad);

    List<Ad> selectAllAd();
    
    int insert(Map ad);
}
