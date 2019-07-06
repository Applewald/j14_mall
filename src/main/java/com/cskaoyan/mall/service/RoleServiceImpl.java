package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 22:19
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public int insert(Role record) {
        int i = roleMapper.insert(record);
        return i;
    }

    /*@Override
    public ReVo selectAllRole(Integer page, Integer limit, String sort, String order, String name) {
        PageHelper.startPage(page, limit);
        //OrderByHelper.orderBy(sort + " " + order);
        List<Role> roles = roleMapper.selectAllRole(sort, order, name);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);

        Data<Role> roleData = new Data<>(pageInfo.getList(), pageInfo.getTotal());

        ReVo reVo = new ReVo();
        reVo.setData(roleData);
        reVo.setErrmsg("成功");
        reVo.setErrno(0);
        return reVo;
    }*/

    @Override
    public List<AdminOptions> selectAllRoleIdAndName() {
        return roleMapper.selectAllRoleIdAndName();
    }

    @Override
    public List<Role> selectAllRoleList(Integer page, Integer limit, String sort, String order, String name) {
        PageHelper.startPage(page, limit);
        List<Role> roles = roleMapper.selectAllRole(sort, order, name);
        return roles;
    }
}
