package com.cskaoyan.mall.admin.bean;

import java.util.List;

public class RegionChildren {
    private Integer id;

    private String name;

    private Byte type;

    private Integer code;

    private List<RegionChildren> children;

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
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<RegionChildren> getChildren() {
        return children;
    }

    public void setChildren(List<RegionChildren> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RegionChildren{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code=" + code +
                ", children=" + children +
                '}';
    }
}