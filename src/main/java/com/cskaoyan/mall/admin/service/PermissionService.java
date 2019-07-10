package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.permission.Permission;

import java.util.Set;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 11:30
 * @description
 */
public interface PermissionService {

    Set<String> queryByRoleIds(Integer[] roleIds);

    Set<String> queryByRoleId(Integer roleId);

    boolean checkSuperPermission(Integer roleId);

    void deleteByRoleId(Integer roleId);

    void add(Permission permission);
}
