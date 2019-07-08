package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CreateStorge;
import com.cskaoyan.mall.admin.bean.storage.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreateStorgeMapper {

    int insertCreategory(CreateStorge createStorge);

    CreateStorge findCreategoryBy(@Param("url") String url);

    List<Storage> selectAllStorageList(@Param("sort") String sort,
                                       @Param("order") String order,
                                       @Param("key") String key,
                                       @Param("name") String name);

    int deleteById(@Param("id") Integer id);

    int updateByStorage(@Param("storage") Storage storage);

}

