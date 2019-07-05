package com.cskaoyan.mall.vo;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 21:55
 * @description
 */
public class Data<T> {

    List<T> items;

    Long total;

    public Data() {
    }

    public Data(List<T> items, Long total) {
        this.items = items;
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
