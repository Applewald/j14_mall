package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.MallSystem;

import java.util.List;
import java.util.Map;

public interface MallSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallSystem record);

    int insertSelective(MallSystem record);

    MallSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallSystem record);

    int updateByPrimaryKey(MallSystem record);



    List<MallSystem> selectMallSystem(String s);

    List<MallSystem> selectFreightSystem();

    List<MallSystem> selectOrderConfig();

    List<MallSystem> selectWxConfig();

    int  updateMallSystemBykeyName(MallSystem mallSystem);
}