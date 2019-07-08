package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.LoginBean;
import com.cskaoyan.mall.bean.admin.Admin;
import com.cskaoyan.mall.bean.admin.ReqAdmin;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.PermissionService;
import com.cskaoyan.mall.service.RoleService;
import com.cskaoyan.mall.vo.ResponseVo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 15:16
 * @description 登录、注销
 */
@RestController
//@RequestMapping("/auth")
public class AuthController {

    /*@Autowired
    AdminService adminService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @PostMapping("/login")
    public Object login(@RequestBody ReqAdmin reqAdmin, HttpServletRequest request) {

        String username = reqAdmin.getUsername();
        String password = reqAdmin.getPassword();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResponseVo.fail("用户帐号或密码不正确", 605);
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(username, password));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVo.fail("用户帐号或密码不正确", 605);
        }

        currentUser = SecurityUtils.getSubject();
        Admin admin = adminService.selectByUserName(username);

        // userInfo
        Map<String, Object> adminInfo = new HashMap<String, Object>();
        adminInfo.put("name", admin.getUsername());
        adminInfo.put("avatar", admin.getAvatar());

        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", currentUser.getSession().getId());
        result.put("adminInfo", adminInfo);
        return ResponseVo.ok(result);
    }


    @PostMapping("/logout")
    public Object logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseVo.ok();
    }


    @Autowired
    LoginBean loginBean;

    @GetMapping("/info")
    public Object info() {
        Subject currentUser = SecurityUtils.getSubject();
        Admin admin = (Admin) currentUser.getPrincipal();

        Integer[] roleIds = admin.getRoleIds();
        loginBean.setName(admin.getUsername());
        loginBean.setAvastar(admin.getAvatar());

        Set<String> permissions = permissionService.queryByRoleIds(roleIds);
        Set<String> roles = roleService.queryByIds(roleIds);
        loginBean.setPerms(new ArrayList(permissions));
        loginBean.setRoles(new ArrayList(roles));

        return ResponseVo.ok(loginBean);
    }


    @GetMapping("/401")
    public Object page401() {
        return ResponseVo.fail("请登录", 501);
    }

    @GetMapping("/index")
    public Object pageIndex() {
        return ResponseVo.ok();
    }

    @GetMapping("/403")
    public Object page403() {
        return ResponseVo.fail("无操作权限", 506);
    }*/

}
