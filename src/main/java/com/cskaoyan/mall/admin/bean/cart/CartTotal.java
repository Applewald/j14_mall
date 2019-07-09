package com.cskaoyan.mall.admin.bean.cart;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 17:42
 */

public class CartTotal {
    long checkedGoodsAmount;
    long checkedGoodsCount;
    long goodsAmount;
    long goodsCount;

    public long getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(long checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public long getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(long checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public long getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(long goodsAmount) {
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

    public CartTotal(long checkedGoodsAmount, long checkedGoodsCount, long goodsAmount, long goodsCount) {
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
