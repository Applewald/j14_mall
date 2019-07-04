package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Admin;

import java.util.List;

import com.cskaoyan.mall.bean.AdminResp;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<AdminResp> selectAllAdmin();

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}