package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.annotation.Log;
import com.cskaoyan.mall.admin.bean.LoginBean;
import com.cskaoyan.mall.admin.bean.admin.Admin;
import com.cskaoyan.mall.admin.bean.admin.ReqAdmin;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.token.UserToken;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.util.JacksonUtil;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 15:16
 * @description 登录、注销
 */
@RestController
@RequestMapping("/admin")
public class AuthController {

    private Map<String, Object> loginMap = new HashMap<>();

    @Autowired
    AdminService adminService;

    @Autowired
    RoleService roleService;

    @Autowired
    com.cskaoyan.mall.service.PermissionService permissionService;

   // @Log(value = "登录")
    @PostMapping("/auth/login")
    public Object login(@RequestBody String body) {

        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return ResponseVo.fail("用户帐号或密码不正确", 605);
        }

        Subject currentUser = SecurityUtils.getSubject();

        ResponseVo<String> responseVo = new ResponseVo<>();
        try {
            currentUser.login(new UsernamePasswordToken(username, password));
            String id = currentUser.getSession().getId().toString();
            responseVo.setData(id);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVo.fail("用户帐号或密码不正确", 605);
        }

        return responseVo;
    }

    @GetMapping("/auth/info")
    public Object info() {

        Subject subject = SecurityUtils.getSubject();
        Admin admin = (Admin) subject.getPrincipal();

        Integer[] roleIds = admin.getRoleIds();
        Set<String> permissions = permissionService.queryByRoleIds(roleIds);
        Set<String> roles = roleService.queryByIds(roleIds);

        Map<String, Object> result = new HashMap<>();
        result.put("perms", permissions);
        result.put("roles", roles);
        result.put("name", admin.getUsername());
        result.put("avatar", admin.getAvatar());
        return ResponseVo.ok(result);
    }

   // @Log(value = "退出")
    @PostMapping("/auth/logout")
    public Object logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseVo.ok();
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
    }

}
