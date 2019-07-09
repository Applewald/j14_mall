package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.cart.CartExample;
import com.cskaoyan.mall.admin.bean.cart.CartTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
    //**************************************

//1
    List<Cart> queryAllCartsByUid(@Param("userId") Integer userId);

    CartTotal queryCartCount();
//2
    int updateCheckedByUidAndPids(@Param("userId") Integer userId,@Param("isChecked") Integer isChecked,
                                  @Param("productIds") List<Integer> productIds);

//*************************************************************************

    //

}