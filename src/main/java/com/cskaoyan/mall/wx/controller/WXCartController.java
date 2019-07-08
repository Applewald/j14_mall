package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.cart.CartIndex;
import com.cskaoyan.mall.admin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/8 17:46
 */
@RestController
public class WXCartController {

    @Autowired
    CartService cartService;
    @RequestMapping("wx/cart/index")  //有问题
    public ResponseVo<CartIndex> cart(){
        ResponseVo<CartIndex> responseVo = new ResponseVo<>();
        CartIndex cartIndex = cartService.queryCartIndex();
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

    @RequestMapping("wx/cart/add")
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
    }


}
