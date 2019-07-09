package com.cskaoyan.mall.admin.vo;

import java.util.List;

/**
 * author : summer
 * date 2019/7/3 20:34
 */
public class PageVo<T> {
    int total;
    List<T> items;



    public PageVo() {
    }

    public PageVo(int total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
