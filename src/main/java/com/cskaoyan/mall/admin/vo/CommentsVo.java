package com.cskaoyan.mall.admin.vo;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/9 15:23
 */
public class CommentsVo<T> {
    int count;
    int currentPage;
    List<T> data;
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public List<T> getData() {
        return data;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }
}
