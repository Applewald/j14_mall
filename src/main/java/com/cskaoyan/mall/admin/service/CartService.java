package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.cart.CartIndex;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 18:00
 */

public interface CartService {
    CartIndex queryCartIndex(Integer userId);

    int addCart(int goodsId, int number, int productId);
}
