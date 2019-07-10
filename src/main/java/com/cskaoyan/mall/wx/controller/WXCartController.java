package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.cart.*;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 17:46
 */
@RestController
public class WXCartController {

    @Autowired
    CartService cartService;
    //11111获取购物车的数据
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
    //22222 选中checked
    @RequestMapping("wx/cart/checked")
    public ResponseVo<CartIndex> checked(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //获取请求数据
        Integer isChecked = (Integer) map.get("isChecked");
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        //通过token 获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);
        //
        int update = cartService.updateCartChecked(userId,isChecked,productIds);
        //ResponseVo<Map<String,Object>> responseVo = new ResponseVo<>();

        ResponseVo<CartIndex> responseVo = new ResponseVo<>();
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
    //333333333333 add添加商品到购物车


    @RequestMapping("wx/cart/add")
    public ResponseVo addCart(@RequestBody Cart cart,HttpServletRequest request) {
        //通过token 获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);

        cart.setChecked(true);
        cart.setUserId(userId);
        int add = cartService.addCart(cart);


        CartIndex cartIndex = cartService.queryCartIndex(userId);
        List<Cart> cartList = cartIndex.getCartList();
        int data = 0;
        for(Cart cart1 : cartList){
            data += cart1.getNumber();
        }
        ResponseVo responseVo = new ResponseVo<>();
        responseVo.setData(data);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");

        return responseVo;
    }

    //44444  wx/cart/goodscount
    @RequestMapping("wx/cart/goodscount")
    public ResponseVo goodsCount(HttpServletRequest request){
        //通过token 获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);
        CartIndex cartIndex = cartService.queryCartIndex(userId);
        List<Cart> cartList = cartIndex.getCartList();
        int data = 0;
        for(Cart cart : cartList){
            data += cart.getNumber();
        }
        ResponseVo responseVo = new ResponseVo<>();
        responseVo.setData(data);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

//4 wx/cart/delete
    @RequestMapping("wx/cart/delete")
    public ResponseVo<CartIndex> delete(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //获取请求数据
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        //通过token 获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);
        //
        int delete = cartService.deleteCartItem(userId,productIds);

        ResponseVo<CartIndex> responseVo = new ResponseVo<>();
        CartIndex cartIndex = cartService.queryCartIndex(userId);

        if (delete>0){
            responseVo.setData(cartIndex);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;


    }

    //5 update
    @RequestMapping("wx/cart/update")
    public ResponseVo cartUpdate(@RequestBody Map<String,Object> map,HttpServletRequest request){

        //获取请求参数
        Integer productId = (Integer) map.get("productId");
        Integer id =(Integer) map.get("id");
        Integer goodsId = (Integer) map.get("goodsId");
        Integer number = (Integer) map.get("number");

        String token = request.getHeader("X-Litemall-Token");
        Integer uid = UserTokenManager.getUserId(token);
        ResponseVo responseVo = new ResponseVo();
        int update = cartService.updateCartNumber(id,number);
        if(update>0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            return responseVo;
        }else{
            responseVo.setErrno(1);
            responseVo.setErrmsg("error");
            return responseVo;
        }
    }

    //66cart/fastadd' 立即购买商品

   /* @RequestMapping("wx/cart/fastadd")
    public ResponseVo cartFastadd(@RequestBody Map<String,Object> map,HttpServletRequest request){
        ResponseVo responseVo = new ResponseVo();

        Integer productId = (Integer) map.get("productId");
        Integer goodsId = (Integer) map.get("goodsId");
        Integer number = (Integer) map.get("number");

        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);

        int cartId = cartService.selectCartId(userId,productId);
        if (cartId!=0){
            responseVo.setData(cartId);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }*/


    //'cart/checkout' 下单前信息确认

 @RequestMapping("wx/cart/checkout")
    public ResponseVo cartCehckout(@RequestBody Map<String,Object> map ,HttpServletRequest request){

     String token = request.getHeader("X-Litemall-Token");
     Integer userId = UserTokenManager.getUserId(token);
 }



}
