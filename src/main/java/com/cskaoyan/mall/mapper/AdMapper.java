package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Ad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:26
 */
public interface AdMapper {
    
    List<Ad> getAllAd(@Param("sort") String sort, @Param("order")String order);
    
    int updateById(Ad ad);
}
