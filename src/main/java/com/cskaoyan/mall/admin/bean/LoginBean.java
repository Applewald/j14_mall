package com.cskaoyan.mall.admin.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author lixiaolong
 * date: 2019-07-03 16:35
 * description:
 */
@ConfigurationProperties(prefix = "admin.login")
@Component
public class LoginBean {
    private List roles;
    private String name;
    private List perms;
    private String avastar;

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPerms() {
        return perms;
    }

    public void setPerms(List perms) {
        this.perms = perms;
    }

    public String getAvastar() {
        return avastar;
    }

    public void setAvastar(String avastar) {
        this.avastar = avastar;
    }
}
