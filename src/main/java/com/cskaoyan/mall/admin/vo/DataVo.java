package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class DataVo<T> {

    Long total;
    List<T> items;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
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
