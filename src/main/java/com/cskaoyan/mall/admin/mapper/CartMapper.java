package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.cart.CartTotal;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
    //**************************************


    List<Cart> queryAllCartsByUid();

    CartTotal queryCartCount();

    int addCart(int goodsId, int number, int productId);
}