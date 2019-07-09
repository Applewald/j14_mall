package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.cart.CartIndex;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 17:46
 */
@RestController
public class WXCartController {

    @Autowired
    CartService cartService;
    //获取购物车的数据   完成
    @RequestMapping("wx/cart/index")
    public ResponseVo<CartIndex> cart(HttpServletRequest request){
        ResponseVo<CartIndex> responseVo = new ResponseVo<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        CartIndex cartIndex = cartService.queryCartIndex(userId);
        if (cartIndex != null){
            responseVo.setData(cartIndex);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;

    }
    // 添加商品到购物车
 /*   @RequestMapping("wx/cart/add")
    public ResponseVo cartAdd(int goodsId,int number,int productId){
        ResponseVo responseVo = new ResponseVo();
        int data = cartService.addCart(goodsId,number,productId);
        if (data >=1){
            responseVo.setData(data);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }*/

    //cart/fastadd' 立即购买商品
/*    @RequestMapping("wx/cart/fastadd")
    public ResponseVo cartFastadd(int goodsId,int number,int productId){
        ResponseVo responseVo = new ResponseVo();
        int data = cartService.fastAdd(goodsId,number,productId);
        if (data >=1){
            responseVo.setData(data);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }*/


    //'cart/checkout', // 下单前信息确认
   /* @RequestMapping("wx/cart/checkout")

    cartId:61
    addressId:0
    couponId:0
    grouponRulesId:*/
    //'cart/update', // 更新购物车的商品
    //cart/delete', 删除购物车的商品
    ////  'cart/checked'选择或取消选择商品
    //'cart/goodscount', // 获取购物车商品件数


}
