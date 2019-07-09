package com.cskaoyan.mall.admin.bean.statictics;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/6 14:54
 */

public class OrderStat {
    long amount;
    long customers;
    BigDecimal orders;
    BigDecimal pcr;
    Date day;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getCustomers() {
        return customers;
    }

    public void setCustomers(long customers) {
        this.customers = customers;
    }

    public BigDecimal getOrders() {
        return orders;
    }

    public void setOrders(BigDecimal orders) {
        this.orders = orders;
    }

    public BigDecimal getPcr() {
        return pcr;
    }

    public void setPcr(BigDecimal pcr) {
        this.pcr = pcr;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public OrderStat() {
    }

    public OrderStat(long amount, long customers, BigDecimal orders, BigDecimal pcr, Date day) {
        this.amount = amount;
        this.customers = customers;
        this.orders = orders;
        this.pcr = pcr;
        this.day = day;
    }

    @Override
    public String toString() {
        return "OrderStat{" +
                "amount=" + amount +
                ", customers=" + customers +
                ", orders=" + orders +
                ", pcr=" + pcr +
                ", day=" + day +
                '}';
    }
}
