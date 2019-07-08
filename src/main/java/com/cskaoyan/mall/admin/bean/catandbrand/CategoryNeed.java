package com.cskaoyan.mall.admin.bean.catandbrand;

import java.util.List;

public class CategoryNeed{

    private int value;
    private String label;
    List<Children> children;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
