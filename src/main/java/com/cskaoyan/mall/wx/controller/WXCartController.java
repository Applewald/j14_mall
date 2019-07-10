package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.cart.Cart;
import com.cskaoyan.mall.admin.bean.cart.CartCheckout;
import com.cskaoyan.mall.admin.bean.cart.CartTotal;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.cart.CartIndex;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseVo addCart(@RequestBody Map<String,Object> map,HttpServletRequest request){
        //获取请求数据
        Integer isChecked = (Integer) map.get("isChecked");
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        //通过token 获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);

        CartIndex cartIndex = cartService.queryCartIndex(userId);
        List<Cart> cartList = cartIndex.getCartList();

        //int data = cartService.getCartCount(userId,isChecked,productIds);
        int data = cartList.size();
        ResponseVo responseVo = new ResponseVo<>();
        if (data>=0){
            responseVo.setData(data);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
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
        int data = cartList.size();
        ResponseVo responseVo = new ResponseVo<>();
        if (data>=0){
            responseVo.setData(data);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(1);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }



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


  /*  cartId:61
    addressId:0
    couponId:0
    grouponRulesId:
*/


    //'cart/update', // 更新购物车的商品
    //cart/delete', 删除购物车的商品
    ////  'cart/checked'选择或取消选择商品
    //'cart/goodscount', // 获取购物车商品件数


}
