package com.cskaoyan.mall.admin.bean.cart;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 20:07
 */

public class CartIndex {
    List<Cart> cartList;
    CartTotal cartTotal;

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }

    public CartIndex() {
    }

    public CartIndex(List<Cart> cartList, CartTotal cartTotal) {
        this.cartList = cartList;
        this.cartTotal = cartTotal;
    }

    @Override
    public String toString() {
        return "CartIndex{" +
                "cartList=" + cartList +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
