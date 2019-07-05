package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;


import java.util.List;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 22:19
 * @description
 */
public interface RoleService {

    int insert(Role record);

    ReVo selectAllRole(Integer page, Integer limit, String sort, String order, String name);

    List<AdminOptions> selectAllRoleIdAndName();

    List<Role> selectAllRoleList(Integer page, Integer limit, String sort, String order, String name);
}
