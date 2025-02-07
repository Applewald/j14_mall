package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.promotion.Ad;
import com.cskaoyan.mall.admin.mapper.AdMapper;
import com.cskaoyan.mall.admin.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:25
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;
    
    @Override
    public PageInfo<Ad> getAllAd(int page, int limit, String name,String content,String sort, String order) {
        PageHelper.startPage(page,limit);
        if(name == null){
            name = "";
        }
        if(content == null){
            content = "";
        }
        name = "%" + name + "%";
        content = "%" + content + "%";
        List<Ad> list = adMapper.getAllAd(name,content,sort,order);
        PageInfo<Ad> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public int updateByAdId(Ad ad) {
        return adMapper.updateById(ad);
    }
    
    @Override
    public int deleteByAdId(Ad ad) {
        int id = ad.getId();
        return adMapper.deleteByAdId(id);
    }

    @Override
    public List<Ad> selectAllAd() {
        return adMapper.selectAllAd();
    }
    
    @Override
    public int insert(Map ad) {
        return adMapper.insertAd(ad);
    }
}
