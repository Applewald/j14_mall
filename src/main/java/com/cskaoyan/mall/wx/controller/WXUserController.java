package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.wx.wxVo.WXPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * author : summer
 * date 2019/7/8 20:47
 *微信小程序前台相关的user controller
 */
@Controller
@RequestMapping("wx")
public class WXUserController {
    @Autowired
    AddressService addressService;

    @RequestMapping("address/list")
    @ResponseBody
    public ResponseVo getList() {
        ResponseVo<Object> objectResponseVo = new ResponseVo<>();
        List<Address> addressList = (List<Address>) addressService.getAddressList();
        if (addressList.size() > -1){
            objectResponseVo.setData(addressList);
            objectResponseVo.setErrmsg("成功");
            objectResponseVo.setErrno(0);
        } else {
            objectResponseVo.setData(null);
            objectResponseVo.setErrmsg("失败");
            objectResponseVo.setErrno(-1);
        }
        return objectResponseVo;
    }

    @RequestMapping("address/delete")
    @ResponseBody
    public ResponseVo delete(@RequestBody Map<String,Integer> map) {
        ResponseVo responseVo= new ResponseVo<>();
       int delete = addressService.deleteAddress(map.get("id"));
        if(delete == 1 ) {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        } else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(-1);
        }
        return responseVo;
    }

    @Autowired
    FootprintService footprintService;

    @RequestMapping("footprint/list")
    @ResponseBody
    public ResponseVo<WXPageVo<Footprint> > list(int page, int size) {
        ResponseVo<WXPageVo<Footprint> >  PageVo = footprintService.list(page,size);
        return PageVo;

    }
}
