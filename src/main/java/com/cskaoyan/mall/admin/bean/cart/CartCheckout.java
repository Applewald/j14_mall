package com.cskaoyan.mall.admin.bean.cart;

import com.cskaoyan.mall.admin.bean.Address;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/9 15:43
 */

public class CartCheckout {
    BigDecimal actualPrice;
    Integer addressId;
    Integer availableCouponLength;

    Address checkedAddress;
    List<Cart> checkedGoodsList;

    Integer couponId;
    BigDecimal couponPrice;
    BigDecimal freightPrice;
    BigDecimal goodsTotalPrice;
    BigDecimal grouponPrice;
    Integer grouponRulesId;
    BigDecimal orderTotalPrice;

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(Integer availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public Address getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(Address checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public List<Cart> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<Cart> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public Integer getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(Integer grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public CartCheckout() {
    }

    public CartCheckout(BigDecimal actualPrice, Integer addressId, Integer availableCouponLength, Address checkedAddress, List<Cart> checkedGoodsList, Integer couponId, BigDecimal couponPrice, BigDecimal freightPrice, BigDecimal goodsTotalPrice, BigDecimal grouponPrice, Integer grouponRulesId, BigDecimal orderTotalPrice) {
        this.actualPrice = actualPrice;
        this.addressId = addressId;
        this.availableCouponLength = availableCouponLength;
        this.checkedAddress = checkedAddress;
        this.checkedGoodsList = checkedGoodsList;
        this.couponId = couponId;
        this.couponPrice = couponPrice;
        this.freightPrice = freightPrice;
        this.goodsTotalPrice = goodsTotalPrice;
        this.grouponPrice = grouponPrice;
        this.grouponRulesId = grouponRulesId;
        this.orderTotalPrice = orderTotalPrice;
    }

    @Override
    public String toString() {
        return "CartCheckout{" +
                "actualPrice=" + actualPrice +
                ", addressId=" + addressId +
                ", availableCouponLength=" + availableCouponLength +
                ", checkedAddress=" + checkedAddress +
                ", checkedGoodsList=" + checkedGoodsList +
                ", couponId=" + couponId +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", grouponPrice=" + grouponPrice +
                ", grouponRulesId=" + grouponRulesId +
                ", orderTotalPrice=" + orderTotalPrice +
                '}';
    }
}
