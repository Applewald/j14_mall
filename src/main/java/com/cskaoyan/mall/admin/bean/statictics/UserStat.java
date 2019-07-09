package com.cskaoyan.mall.admin.bean.statictics;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/7 10:17
 */

public class UserStat {
    Date day;
    BigDecimal users;

    public UserStat() {
    }

    public UserStat(Date day, BigDecimal users) {
        this.day = day;
        this.users = users;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public BigDecimal getUsers() {
        return users;
    }

    public void setUsers(BigDecimal users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserStat{" +
                "day=" + day +
                ", users=" + users +
                '}';
    }
}
