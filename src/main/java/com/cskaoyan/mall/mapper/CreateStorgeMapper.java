package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CreateStorge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateStorgeMapper {
    int insertCreategory(CreateStorge createStorge);

    CreateStorge findCreategoryBy(@Param("id") int id);
}

