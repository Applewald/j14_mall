package com.cskaoyan.mall.admin.shiro;

import com.cskaoyan.mall.admin.bean.admin.Admin;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.service.PermissionService;
import com.cskaoyan.mall.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 10:18
 * @description 自定义reaml：认证授权会执行它，需要自己写
 */
public class MallShiroRealm extends AuthorizingRealm {

    @Autowired
    RoleService roleService;

    @Autowired
    AdminService adminService;

    @Autowired
    PermissionService permissionService;

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 通过token拿到用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());

        // 获取数据库中的密码
        //String passwordInDB = adminService.selectByUserName(username).getPassword();

        Admin admin = adminService.selectByUserName(username);
        String passwordInDB = admin.getPassword();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new AccountException("请正确输入用户名和密码");
        }

        String password2md5 = "123";
        try {
            password2md5 = MD5Util.getMD5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 密码不对就抛出异常
        if (!passwordInDB.equals(password2md5)) {
            throw new AuthenticationException("密码错误");
        }

        // 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :MallShiroRealm
        return new SimpleAuthenticationInfo(admin, password, getName());

    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 拿到登录的admin
        Admin admin = (Admin) getAvailablePrincipal(principalCollection);
        Integer[] roleIds = admin.getRoleIds();
        Set<String> roles = roleService.queryByIds(roleIds);
        Set<String> permissions = permissionService.queryByRoleIds(roleIds);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }


}
