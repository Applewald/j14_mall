package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.role.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 22:19
 * @description 系统管理 - 角色管理 - service层
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int insertByRole(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int updateByRole(Role role) {
        return roleMapper.updateByRole(role);
    }

    @Override
    public Role selectRoleByName(String name) {
        return roleMapper.selectRoleByName(name);
    }

    @Override
    public List<AdminOptions> selectAllRoleIdAndName() {
        return roleMapper.selectAllRoleIdAndName();
    }

    @Override
    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<>();
        if(roleIds.length == 0){
            return roles;
        }

        List<Integer> integers = Arrays.asList(roleIds);

        for (Integer id : integers) {
            Role role = roleMapper.selectRoleById(id);
            roles.add(role.getName());
        }

        return roles;
    }

    @Override
    public DataVo selectAllRoleList(Integer page, Integer limit, String sort, String order, String name) {
        PageHelper.startPage(page, limit);
        List<Role> roles = roleMapper.selectAllRole(sort, order, name);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        DataVo<Role> dataVo = new DataVo<>();
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        return dataVo;
    }
}
