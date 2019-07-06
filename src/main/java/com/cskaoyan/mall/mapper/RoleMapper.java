package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.role.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("role") Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    Role selectByName(@Param("name") String name);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<AdminOptions> selectAllRoleIdAndName();

    List<Role> selectAllRole(@Param("sort") String sort, @Param("order") String order, @Param("name") String name);

}