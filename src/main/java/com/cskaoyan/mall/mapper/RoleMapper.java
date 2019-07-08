package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.role.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int insert(@Param("role") Role record);

    int deleteById(@Param("id") Integer id);

    int updateByRole(@Param("role") Role role);

    Role selectRoleByName(@Param("name") String name);

    Role selectRoleById(@Param("id") Integer id);

    List<AdminOptions> selectAllRoleIdAndName();

    List<Role> selectAllRole(@Param("sort") String sort, @Param("order") String order, @Param("name") String name);

}