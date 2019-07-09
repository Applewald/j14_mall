package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.bean.BrandExample;
import com.cskaoyan.mall.admin.bean.wxhome.BrandList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> findBrandList(@Param("id") Integer id, @Param("name") String name, @Param("sort") String sort, @Param("order") String order);

    @Select("select `id`, `name`, `desc`, pic_url as picUrl, floor_price as floorPrice from cskaoyan_mall_brand where deleted = 0 ")
    List<BrandList> selectAllBrand();
}