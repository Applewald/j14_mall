package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CreateStorge;
import org.apache.ibatis.annotations.Param;

public interface CreateStorgeMapper {
    int insertCreategory(CreateStorge createStorge);

    CreateStorge findCreategoryBy(@Param("id") int id);
}

