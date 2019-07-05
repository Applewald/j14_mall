package com.cskaoyan.mall.bean.creategoods;

import com.cskaoyan.mall.bean.Goods;

import java.util.List;

public class CreateGoods {

    private List<Attribute> attributes;
    private Goods goods;
    private List<Product> products;
    private List<Specification> specifications;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }


    @Override
    public String toString() {
        return "CreateGoods{" +
                "attributes=" + attributes +
                ", goods=" + goods +
                ", products=" + products +
                ", specifications=" + specifications +
                '}';
    }
}
