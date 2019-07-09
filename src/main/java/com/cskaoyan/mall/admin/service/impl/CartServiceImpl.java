package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.cart.*;
import com.cskaoyan.mall.admin.mapper.CartMapper;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    //1
    @Override
    public CartIndex queryCartIndex(Integer userId) {
        CartIndex cartIndex  = new CartIndex();

        List<Cart> cartList = cartMapper.queryAllCartsByUid(userId);
        cartIndex.setCartList(cartList);

        BigDecimal sumPrice = new BigDecimal(0);
        BigDecimal checked = new BigDecimal(0);

        for(int i=0;i < cartList.size();i++){
            Cart cart = cartList.get(i);

            sumPrice = sumPrice.add(cart.getPrice());

            if(cart.getChecked().equals(true)){
                checked = checked.add(cart.getPrice());
            }
        }
       // CartTotal cartTotal = cartMapper.queryCartCount();
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsCount(cartList.size());
        cartTotal.setGoodsAmount(sumPrice);
        cartTotal.setCheckedGoodsCount(cartList.size());
        cartTotal.setCheckedGoodsAmount(checked);

        cartIndex.setCartTotal(cartTotal);
        return cartIndex;
    }

//2

    @Override
    public int updateCartChecked(Integer userId, Integer isChecked, List<Integer> productIds) {
        return cartMapper.updateCheckedByUidAndPids(userId,isChecked,productIds);
    }
}
