package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.cart.CartIndex;
import com.cskaoyan.mall.admin.bean.cart.CartTotal;
import com.cskaoyan.mall.admin.mapper.CartMapper;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 18:02
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public CartIndex queryCartIndex() {
        CartIndex cartIndex  = new CartIndex();

        List<Cart> cartList = cartMapper.queryAllCartsByUid();
        cartIndex.setCartList(cartList);

        CartTotal cartTotal = cartMapper.queryCartCount();
        cartIndex.setCartTotal(cartTotal);
        return cartIndex;
    }

    @Override
    public int addCart(int goodsId, int number, int productId) {
        return cartMapper.addCart(goodsId,number,productId);
    }
}
