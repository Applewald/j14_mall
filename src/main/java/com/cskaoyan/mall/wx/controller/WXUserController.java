package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Address;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.bean.Search;
import com.cskaoyan.mall.admin.bean.SearchHistory;
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

    @RequestMapping("address/save")
    @ResponseBody
    public ResponseVo insertAddress(@RequestBody Map<String,Integer> map) {
        ResponseVo vo= new ResponseVo<>();
        int insert = addressService.insertAddress(map.get("id"));
        if(insert == 1) {
            vo.setData(map.get("id"));
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setData(null);
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
    public ResponseVo submitFeedback(@RequestBody Map<String, Feedback> map) {
         ResponseVo vo= new ResponseVo<>();
        int submit = feedbackService.submitFeedback(map.get("feedback"));
         if(submit == 1) {
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

    @RequestMapping("search/index")
    @ResponseBody
    public ResponseVo historyList(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        Search search = searchHistoryService.querySearchHistory(userId);
        ResponseVo vo= new ResponseVo<>();
        if(search != null) {
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrmsg("系统内部错误");
            vo.setErrno(502);
        }
        return vo;
    }
}
