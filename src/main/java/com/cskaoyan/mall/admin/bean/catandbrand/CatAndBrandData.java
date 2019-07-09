package com.cskaoyan.mall.admin.bean.catandbrand;

import java.util.List;

public class CatAndBrandData {

    private List<BrandMap> brandList;
    private List<CategoryNeed> categoryList;

    public List<BrandMap> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandMap> brandList) {
        this.brandList = brandList;
    }

    public List getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List categoryList) {
        this.categoryList = categoryList;
    }
}


