package com.cskaoyan.mall.admin.bean.cart;

import java.math.BigDecimal;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 17:42
 */

public class CartTotal {
    BigDecimal checkedGoodsAmount;
    long checkedGoodsCount;
    BigDecimal goodsAmount;
    long goodsCount;

    public BigDecimal getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(BigDecimal checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public long getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(long checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public long getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(long goodsCount) {
        this.goodsCount = goodsCount;
    }

    public CartTotal() {
    }

    public CartTotal(BigDecimal checkedGoodsAmount, long checkedGoodsCount, BigDecimal goodsAmount, long goodsCount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
        this.checkedGoodsCount = checkedGoodsCount;
        this.goodsAmount = goodsAmount;
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "CartTotal{" +
                "checkedGoodsAmount=" + checkedGoodsAmount +
                ", checkedGoodsCount=" + checkedGoodsCount +
                ", goodsAmount=" + goodsAmount +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
