package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.admin.bean.permission.Permission;
import com.cskaoyan.mall.admin.bean.permission.PermissionExample;
import com.cskaoyan.mall.admin.mapper.PermissionMapper;
import com.cskaoyan.mall.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 11:31
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<>();
        if(roleIds.length == 0){
            return permissions;
        }

        PermissionExample example = new PermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<Permission> permissionList = permissionMapper.selectByExample(example);

        for(Permission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    @Override
    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<>();
        if(roleId == null){
            return permissions;
        }

        PermissionExample example = new PermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<Permission> permissionList = permissionMapper.selectByExample(example);

        for(Permission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    @Override
    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        PermissionExample example = new PermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    @Override
    public void deleteByRoleId(Integer roleId) {
        PermissionExample example = new PermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.deleteByExample(example);
    }

    @Override
    public void add(Permission permission) {
        permission.setAddTime(new Date());
        permission.setUpdateTime(new Date());
        permissionMapper.insertSelective(permission);
    }
}
