package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.RoleMapper;

import com.cskaoyan.mall.vo.Data;
import com.cskaoyan.mall.vo.ReVo;

import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ResponseVo insert(Role record) {

        Role role = roleMapper.selectByName(record.getName());
        ResponseVo<Role> roleResponseVo = new ResponseVo<>();

        if (role == null) {
            int i = roleMapper.insert(record);
            Role role2 = roleMapper.selectByName(record.getName());
            roleResponseVo.setData(role2);
            roleResponseVo.setErrmsg("成功");
            roleResponseVo.setErrno(0);
        } else {
            roleResponseVo.setData(role);
            roleResponseVo.setErrmsg("成功");
            roleResponseVo.setErrno(0);
        }

        return roleResponseVo;
    }

    @Override
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
    }
}
