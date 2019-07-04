package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.MallSystem;

import java.util.List;

public interface MallSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallSystem record);

    int insertSelective(MallSystem record);

    MallSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallSystem record);

    int updateByPrimaryKey(MallSystem record);

    List<MallSystem> selectMallSystem(String s);

    List<MallSystem> selectFreightSystem();
}