package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.role.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import com.cskaoyan.mall.service.RoleService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 17:45
 * @description
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /*adminOptions*/
    @RequestMapping("/options")
    public Object roleOptions() {
        List<AdminOptions> adminOptions = roleService.selectAllRoleIdAndName();
        Object ok = ResponseVo.ok(adminOptions);
        return ok;
    }

    /*查询全部的角色, 附带模糊查询*/
    @RequestMapping("/list")
    public Object roleList(Integer page, Integer limit, String sort, String order, String name) {
        DataVo dataVo = roleService.selectAllRoleList(page, limit, sort, order, name);
        return ResponseVo.ok(dataVo);
    }

    /*添加新的角色*//*
    @RequestMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Role role) {
        int i = roleService.insert(role);
        if (i == 1) {
            ReVo reVo = new ReVo(role,"成功",0);
            return reVo;
        } else {
            ReVo reVo = new ReVo("角色已经存在",640);
            return reVo;
        }
    }*/
}