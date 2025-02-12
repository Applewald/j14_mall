package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.cart.*;
import com.cskaoyan.mall.admin.mapper.AddressMapper;
import com.cskaoyan.mall.admin.mapper.CartMapper;
import com.cskaoyan.mall.admin.mapper.CouponMapper;
import com.cskaoyan.mall.admin.service.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 18:02
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CouponMapper couponMapper;

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

    //333333333333 add添加商品到购物车


 /*   @Override
    public int getCartCount(Integer userId, Integer isChecked, List<Integer> productIds) {
        return cartMapper.getCartCount(userId,isChecked,productIds);
    }*/

 //4 delete

    @Override
    public int deleteCartItem(Integer userId, List<Integer> productIds) {
        return cartMapper.deleteCartItem(userId,productIds);
    }


    //5

    @Override
    public int updateCartNumber(Integer id, Integer number) {
        return cartMapper.updateCartNumber( id,number);
    }

    //6


    @Override
    public Integer selectCartId(Integer userId, Integer productId) {
        return cartMapper.selectCartId(userId);

    }
    @Override
    public int addCart(Cart cart){
        Cart cartboolean = cartMapper.findCart(cart);

        int add = 0;
        if (cartboolean == null ){

            Cart cart1 = cartMapper.findFieldFromGoodsAndProduct(cart.getGoodsId(),cart.getProductId());
            cart.setGoodsName(cart1.getGoodsName());
            cart.setGoodsSn(cart1.getGoodsSn());
            cart.setPrice(cart1.getPrice());
            cart.setPicUrl(cart1.getPicUrl());
            cart.setSpecifications(cart1.getSpecifications());
            add= cartMapper.add(cart);
        }else {
            cartMapper.updaCartNumber(cartboolean.getId(),cartboolean.getNumber()+cart.getNumber());
            add++;
        }


        return add;

    }

    @Override
    public int fastAddCart(Cart cart) {
        Cart cartboolean = cartMapper.findCart(cart);

        int add = 0;
        if (cartboolean == null ){

            Cart cart1 = cartMapper.findFieldFromGoodsAndProduct(cart.getGoodsId(),cart.getProductId());
            cart.setGoodsName(cart1.getGoodsName());
            cart.setGoodsSn(cart1.getGoodsSn());
            cart.setPrice(cart1.getPrice());
            cart.setPicUrl(cart1.getPicUrl());
            cart.setSpecifications(cart1.getSpecifications());
            add= cartMapper.add(cart);

            return cartMapper.findCart(cart).getId();
        }else {
            return cartboolean.getId();
        }

    }


    @Override
    public Map<Object, Object> cartCehckout(Integer userId, Integer cartId, Integer addressId, Integer couponId, Integer grouponRelesId) {

        Map<Object,Object> map = new HashMap<>();
        Address checkedAddress = null;
        if (addressId == null || addressId == 0){
            //查默认地址
            checkedAddress = addressMapper.findDefaultAddress(userId);
            if (checkedAddress == null) {
                map.put("addressId", 0);
            } else {
                map.put("addressId", checkedAddress.getId());
            }

        }else {
            checkedAddress = addressMapper.findAddressById(addressId);
            map.put("addressId",addressId);
        }
        map.put("checkedAddress",checkedAddress);

        List<Cart>  checkedGoodsList = cartMapper.findCheckedGoodsListBuUserId(userId);
        map.put("checkedGoodsList",checkedGoodsList);

        BigDecimal goodsTotalPrice = new BigDecimal(0);

        for (Cart cart : checkedGoodsList){
            BigDecimal price = cart.getPrice();
            price = price.multiply(new BigDecimal(cart.getNumber()));
            /*for (int i = 0 ;i <cart.getNumber() ;i++){
                goodsTotalPrice .add(cart.getPrice());
            }*/
            goodsTotalPrice = goodsTotalPrice.add(price);
        }

        //运费0000000000
        map.put("freightPrice",8);
        //
        map.put("goodsTotalPrice",goodsTotalPrice);
        //商品+运费
        map.put("orderTotalPrice",goodsTotalPrice);
        //实际价格
        map.put("actualPrice",goodsTotalPrice);


        //优惠券 乱写
        if (couponId == 0){
            map.put("couponId",0);
            map.put("couponPrice",0);
        }else {
            map.put("couponId",couponId);
            map.put("couponPrice",0);
        }
        map.put("availableCouponLength",0);
        map.put("grouponRulesId",0);

        return map;



    }
}
