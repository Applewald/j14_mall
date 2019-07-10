package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.promotion.Ad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 14:26
 */
public interface AdMapper {
    
    List<Ad> getAllAd(@Param("name")String name,
                      @Param("content")String content,
                      @Param("sort") String sort,
                      @Param("order")String order);
    
    int updateById(Ad ad);
    
    int deleteByAdId(@Param("id") int id);

    @Select("select * from cskaoyan_mall_ad")
    List<Ad> selectAllAd();
    
    int insertAd(Map ad);
}
