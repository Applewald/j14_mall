package com.cskaoyan.mall.admin.bean.promotion;

import java.util.Date;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 15:58
 */
public class CouponUser {
    private Integer id;
    private Integer userId;
    private Integer CouponId;
    private Short status;
    private Date usedTime;
    private Date startTime;
    private Date endTime;
    private Integer orderId;
    private Date addTime;
    private Date updateTime;
    private Boolean deleted;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getCouponId() {
        return CouponId;
    }
    
    public void setCouponId(Integer couponId) {
        CouponId = couponId;
    }
    
    public Short getStatus() {
        return status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
    }
    
    public Date getUsedTime() {
        return usedTime;
    }
    
    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public Date getAddTime() {
        return addTime;
    }
    
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public Boolean getDeleted() {
        return deleted;
    }
    
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
