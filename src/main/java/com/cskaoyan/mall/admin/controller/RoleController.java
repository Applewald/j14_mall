package com.cskaoyan.mall.admin.controller;



import com.cskaoyan.mall.admin.bean.role.Role;
import com.cskaoyan.mall.admin.bean.admin.AdminOptions;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.util.PermissionsUtil;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 17:45
 * @description 系统管理 - 角色管理 - controller层
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /*adminOptions, 管理员页面需要*/
    @RequestMapping("/options")
    public Object roleOptions() {
        List<AdminOptions> adminOptions = roleService.selectAllRoleIdAndName();
        Object ok = ResponseVo.ok(adminOptions);
        return ok;
    }

    /*查询全部的角色, 附带模糊查询*/
    @GetMapping("/list")
    public Object roleList(Integer page, Integer limit, String sort, String order, String name) {
        DataVo dataVo = roleService.selectAllRoleList(page, limit, sort, order, name);
        return ResponseVo.ok(dataVo);
    }

    /*添加角色*/
    @PostMapping("/create")
    public Object roleCreate(@RequestBody Role role) {
        Role find = roleService.selectRoleByName(role.getName());
        if (find == null) {
            roleService.insertByRole(role);
            return ResponseVo.ok();
        } else {
            return ResponseVo.fail("角色已经存在", 640);
        }
    }

    /*删除角色*/
    @PostMapping("/delete")
    public Object roleDelete(@RequestBody Role role) {
        roleService.deleteById(role.getId());
        return ResponseVo.ok();
    }

    /*修改角色*/
    @PostMapping("/update")
    public Object roleUpdate(@RequestBody Role role) {
        roleService.updateByRole(role);
        return ResponseVo.ok();
    }


    /*查看权限*/
    /*@GetMapping("/permissions")
    public Object getPermissions(Integer roleId) {
        List<String> systemPermissions = PermissionsUtil.getSystemPermissions;
        Set<String> assignedPermissions = PermissionsUtil.getAssignedPermissions(roleId);

        Map<String, Object> data = new HashMap<>();
        data.put("systemPermissions", systemPermissions);
        data.put("assignedPermissions", assignedPermissions);
        return ResponseVo.ok(data);
    }*/

}