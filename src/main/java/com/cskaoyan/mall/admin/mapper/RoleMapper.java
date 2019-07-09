package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.role.Role;
import com.cskaoyan.mall.admin.bean.admin.AdminOptions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int insert(@Param("role") Role record);

    int deleteById(@Param("id") Integer id);

    int updateByRole(@Param("role") Role role);

    Role selectRoleByName(@Param("name") String name);

    List<AdminOptions> selectAllRoleIdAndName();

    List<Role> selectAllRole(@Param("sort") String sort, @Param("order") String order, @Param("name") String name);

}