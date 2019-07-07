package com.cskaoyan.mall.bean.statictics;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/6 15:48
 */

public class GoodsStat {
    BigDecimal orders;
    BigDecimal products;
    long amount;
    Date day;

    public BigDecimal getOrders() {
        return orders;
    }

    public void setOrders(BigDecimal orders) {
        this.orders = orders;
    }

    public BigDecimal getRoducts() {
        return products;
    }

    public void setRoducts(BigDecimal roducts) {
        this.products = roducts;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public GoodsStat() {
    }

    @Override
    public String toString() {
        return "GoodsStat{" +
                "orders=" + orders +
                ", products=" + products +
                ", amount=" + amount +
                ", day=" + day +
                '}';
    }

}
