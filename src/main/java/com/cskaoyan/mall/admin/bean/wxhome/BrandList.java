package com.cskaoyan.mall.admin.bean.wxhome;

import java.math.BigDecimal;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-08 22:21
 * @description
 */
public class BrandList {

    private Integer id;

    private String name;

    private String desc;

    private String picUrl;

    private BigDecimal floorPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }
}
