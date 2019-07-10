package com.cskaoyan.mall.wx.wxVo;

import java.util.List;

/**
 * author : summer
 * date 2019/7/9 9:44
 */
public class WXPageVo<T> {
    long page;
    List<T> size;

    public WXPageVo(long total, List<T> list) {
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<T> getSize() {
        return size;
    }

    public void setSize(List<T> size) {
        this.size = size;
    }
}
