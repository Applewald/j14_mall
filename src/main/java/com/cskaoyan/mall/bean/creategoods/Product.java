package com.cskaoyan.mall.bean.creategoods;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    int id;
    int  number;
    BigDecimal price;
    List<String> specifications;
    String url;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", specifications=" + specifications +
                ", url='" + url + '\'' +
                '}';
    }
}
