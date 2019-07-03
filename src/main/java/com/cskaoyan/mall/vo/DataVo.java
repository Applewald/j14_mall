package com.cskaoyan.mall.vo;

import java.util.List;

public class DataVo<T> {

    int total;
    List<T> items;

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
        return "DataVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

}
