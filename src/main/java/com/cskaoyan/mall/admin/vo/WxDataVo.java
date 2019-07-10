package com.cskaoyan.mall.admin.vo;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/9 11:12
 */
public class WxDataVo<T> {
    Long count;
    List<T> data;
    
    public Long getCount() {
        return count;
    }
    
    public void setCount(Long count) {
        this.count = count;
    }
    
    public List<T> getData() {
        return data;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }

    public WxDataVo() {
    }


    public WxDataVo(Long count, List<T> data) {
        this.count = count;
        this.data = data;
    }
}
