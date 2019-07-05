package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.admin.Admin;

import java.util.List;

import com.cskaoyan.mall.bean.admin.AdminResp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {


    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("admin") Admin record);

    int insertSelective(Admin record);

    /* admin/list */
    List<AdminResp> selectAllAdmin(@Param("sort") String sort, @Param("order") String order, @Param("username") String username);


    List<Admin> selectAllAdminList();

    Admin selectByPrimaryKey(@Param("id") Integer id);

    Admin selectByUserName(@Param("username") String username);


    int updateByPrimaryKey(Admin record);
}