package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.catandbrand.BrandMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatAndBrandDataMapper {
    List<BrandMap> findBrandList();

    List findCategoryList();
}

