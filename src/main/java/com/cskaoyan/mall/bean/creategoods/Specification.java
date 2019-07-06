package com.cskaoyan.mall.bean.creategoods;

public class Specification {
    String picUrl ;
    String specification;
    String value;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "picUrl='" + picUrl + '\'' +
                ", specification='" + specification + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
