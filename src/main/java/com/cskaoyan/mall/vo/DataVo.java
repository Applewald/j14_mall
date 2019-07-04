package com.cskaoyan.mall.vo;

import java.util.List;

public class DataVo<T> {

    long total;
    List<T> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
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
        return "DataVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

}
