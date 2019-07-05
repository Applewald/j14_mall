package com.cskaoyan.mall.mapper;


import com.cskaoyan.mall.bean.catandbrand.BrandMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatAndBrandDataMapper {
    List<BrandMap> findBrandList();

    List findCategoryList();
}

