package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.storage.Storage;
//import com.cskaoyan.mall.admin.bean.StorageExample;


public interface StorageMapper {
    //long countByExample(StorageExample example);

    //int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    //List<Storage> selectByExample(StorageExample example);

    //Storage selectByPrimaryKey(Integer id);

    //int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    //int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}