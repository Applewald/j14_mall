package com.cskaoyan.mall.bean;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 16:15
 * @description
 */
public class AdminResp {

    private int id;

    private String username;

    private String avatar;

    private Integer[] roleIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Integer[] roleIds) {
        this.roleIds = roleIds;
    }
}
