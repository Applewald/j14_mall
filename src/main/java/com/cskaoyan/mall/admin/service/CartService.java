package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.cart.CartCheckout;
import com.cskaoyan.mall.admin.bean.cart.CartIndex;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 18:00
 */

public interface CartService {
    CartIndex queryCartIndex(Integer userId);


    int updateCartChecked(Integer userId, Integer isChecked, List<Integer> productIds);

    int deleteCartItem(Integer userId, List<Integer> productIds);

    int addCart(Cart cart);

    //333333333333 add添加商品到购物车

    //int getCartCount(Integer userId, Integer isChecked, List<Integer> productIds);
}
