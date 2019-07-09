package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.creategoods.Specification;

import java.util.List;

/**
 * @author iwppa
 * @version 1.0
 * @date 2019/7/9 17:41
 */
public class SpecificationVo {

    String name;
    List<Specification> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Specification> getValueList() {
        return valueList;
    }

    public void setValueList(List<Specification> valueList) {
        this.valueList = valueList;
    }
}
