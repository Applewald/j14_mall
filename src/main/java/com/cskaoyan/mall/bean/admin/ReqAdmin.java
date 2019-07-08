package com.cskaoyan.mall.bean.admin;

import java.io.Serializable;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 15:49
 * @description
 */
public class ReqAdmin implements Serializable {

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
