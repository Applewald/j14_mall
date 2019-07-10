package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Address;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.bean.Search;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.service.FeedbackService;
import com.cskaoyan.mall.admin.service.FootprintService;

import com.cskaoyan.mall.admin.service.SearchHistoryService;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.vo.ResponseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    public ResponseVo getList(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

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

    @RequestMapping("address/save")
    @ResponseBody
    public ResponseVo insertAddress(HttpServletRequest request,@RequestBody Map<String,Object> map) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //获取address的参数
        Integer provinceId = (Integer) map.get("provinceId");
        Integer cityId = (Integer) map.get("cityId");
        Integer areaId = (Integer) map.get("areaId");
        String address1 = (String) map.get("address");
        //String detailedAddress = (String) map.get("detailedAddress");
        String name = (String) map.get("name");
        String mobile = (String) map.get("mobile");
        Integer isDefault = (Integer) map.get("isDefault");

        Address address = new Address();
        address.setAddress(address1);
        address.setProvinceId(provinceId);
        address.setCityId(cityId);
        address.setAreaId(areaId);
        //address.setDetailedAddress(detailedAddress);
        address.setName(name);
        address.setMobile(mobile);
        address.setUserId(userId);
        address.setAddTime(new Date());
        address.setUpdateTime(new Date());
        if(isDefault == 1){
            address.setIsDefault(true);
        }else {
            address.setIsDefault(false);
        }

        int addressId = addressService.insertAddress(address);

        ResponseVo vo= new ResponseVo<>();
        if(address != null) {
            vo.setData(addressId);
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setData(addressId);
            vo.setErrmsg("系统内部错误");
            vo.setErrno(502);
        }
        return vo;
    }

    @RequestMapping("address/delete")
    @ResponseBody
    public ResponseVo deleteAddress(@RequestBody Map<String,Integer> map) {
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
    public ResponseVo list(int page,int size) {
        ResponseVo footPrintList = footprintService.findFootPrintList(page, size);
        return footPrintList;
    }

    @Autowired
    FeedbackService feedbackService;
    @RequestMapping("feedback/submit")
    @ResponseBody
    public ResponseVo submitFeedback(HttpServletRequest request, @RequestBody Map<String, Object> map) {
         String tokenKey = request.getHeader("X-Litemall-Token");
         Integer userId = UserTokenManager.getUserId(tokenKey);

         String mobile = (String) map.get("mobile");
         Boolean hasPicture = (Boolean) map.get("hasPicture");
         String feedType = (String) map.get("feedType");
         String content = (String) map.get("content");
        Object picUrls = map.get("picUrls");
        List<String> picList = (List<String>) picUrls;

        String[] pics = new String[picList.size()];

        for (int i = 0; i < picList.size(); i++) {
            pics[i] = picList.get(i);
        }
        //String[] picUrls = (String[]) map.get("picUrls");

         Feedback feedback = new Feedback();
         feedback.setAddTime(new Date());
         feedback.setMobile(mobile);
         feedback.setHasPicture(hasPicture);
         feedback.setFeedType(feedType);
         feedback.setContent(content);
         feedback.setPicUrls(pics);
         feedback.setUpdateTime(new Date());
         feedback.setUserId(userId);
         feedback.setStatus(0);
         feedback.setUsername(feedbackService.findUsernameByUserId());
         ResponseVo vo= new ResponseVo<>();
        int submit = feedbackService.submitFeedback(feedback);
         if(feedback != null) {
             vo.setErrmsg("成功");
             vo.setErrno(0);
         } else {
             vo.setErrmsg("系统内部错误");
             vo.setErrno(502);
         }
         return vo;
     }


    @Autowired
    SearchHistoryService searchHistoryService;


}
