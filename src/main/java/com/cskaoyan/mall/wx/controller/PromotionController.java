package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.service.GroupOnService;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.token.UserTokenManager;
import com.cskaoyan.mall.admin.util.JacksonUtil;
import com.cskaoyan.mall.admin.vo.MessageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.vo.TopicVo;
import com.cskaoyan.mall.admin.vo.WxDataVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/8 22:11
 */
@RestController
public class PromotionController {
    
    @Autowired
    TopicService topicService;
    
    @RequestMapping("wx/topic/list")
    public ResponseVo<WxDataVo> list(int page, int size){
        WxDataVo<Map> dataVo = new WxDataVo<>();
        PageInfo<Map> pageInfo = topicService.getTopics(page,size);
        dataVo.setData(pageInfo.getList());
        dataVo.setCount(pageInfo.getTotal());
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    @RequestMapping("wx/topic/detail")
    public ResponseVo<TopicVo> getTopicDetailById(Integer id){
        TopicVo<Topic> topicVo = new TopicVo<>();
        Topic topic = topicService.getTopicById(id);
        topicVo.setTopic(topic);
        ResponseVo<TopicVo> vo = new ResponseVo<>();
        vo.setData(topicVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    
    @RequestMapping("wx/topic/related")
    public ResponseVo<List> getRelatedTopic(int id){
        ResponseVo<List> vo = new ResponseVo<>();
        List<Topic> list = topicService.getRelatedTopic(id);
        vo.setData(list);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~以下为团购部分~~~~~~~~~~~~~~~~~~~~~~*/
    
    @Autowired
    GroupOnService groupOnService;
    
    @RequestMapping("wx/groupon/list")
    public ResponseVo<WxDataVo> groupOnList(int page,int size){
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        PageInfo<Map> pageInfo = groupOnService.getGroupOnList(page,size);
        WxDataVo<Map> dataVo = new WxDataVo<>();
        dataVo.setData(pageInfo.getList());
        dataVo.setCount(pageInfo.getTotal());
        vo.setData(dataVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    
    /*@RequestMapping("wx/groupon/query")
    public ResponseVo<WxDataVo> groupOnList(int page,int size){
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        PageInfo<Map> pageInfo = groupOnService.getGroupOnList(page,size);
        WxDataVo<Map> dataVo = new WxDataVo<>();
        dataVo.setData(pageInfo.getList());
        dataVo.setCount(pageInfo.getTotal());
        vo.setData(dataVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }*/
    
    @RequestMapping("wx/groupon/my")
    public ResponseVo<WxDataVo> groupOnList(int showType){
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        List<Map> list = groupOnService.getMyGroupOnList(showType);
        WxDataVo<Map> dataVo = new WxDataVo<>();
        dataVo.setData(list);
        dataVo.setCount((long)list.size());
        vo.setData(dataVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    
    @RequestMapping("wx/groupon/detail")
    public ResponseVo<Map> groupOnDetail(Integer grouponId){
        ResponseVo<Map> vo = new ResponseVo<>();
        Map<Object,Object> map = groupOnService.getMyGroupOnDetail(grouponId);
        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
    
    /*@RequestMapping("wx/groupon/join")
    public ResponseVo<Map> groupOnDetail(Integer grouponId){
        ResponseVo<Map> vo = new ResponseVo<>();
        Map<Object,Object> map = groupOnService.getMyGroupOnDetail(grouponId);
        vo.setData(map);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }*/
    
    
    /**~~~~~~~~~~~~~~~~~~~~~以下为优惠券部分~~~~~~~~~~~~~~~~~~~~~~*/
    
    @Autowired
    CouponService couponService;
    
    @RequestMapping("wx/coupon/list")
    public ResponseVo<WxDataVo> couponList(int page,int size){
        WxDataVo<Map> dataVo = new WxDataVo<>();
        PageInfo<Map> pageInfo = couponService.getAllCouponBehind(page,size);
        dataVo.setData(pageInfo.getList());
        dataVo.setCount(pageInfo.getTotal());
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    @RequestMapping("wx/coupon/mylist")
    public ResponseVo<WxDataVo> couponList(int page, int size, int status, HttpServletRequest request){
        WxDataVo<Map> dataVo = new WxDataVo<>();
        String header = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(header);
        PageInfo<Map> pageInfo = couponService.getMyCoupon(page,size,status,userId);
        dataVo.setData(pageInfo.getList());
        dataVo.setCount(pageInfo.getTotal());
        ResponseVo<WxDataVo> vo = new ResponseVo<>();
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    /*这个sql语句还没写完*/
    @RequestMapping("wx/coupon/selectlist")
    public ResponseVo<List> selectlist(int cartId,int grouponRulesId){
        ResponseVo<List> vo = new ResponseVo<>();
        List<Map> list = couponService.selectlist(cartId,grouponRulesId);
        vo.setData(list);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }
    
    @RequestMapping("wx/coupon/receive")
    public MessageVo receive(@RequestBody String couponId, HttpServletRequest request){
        String header = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(header);
        MessageVo vo = new MessageVo();
        Integer couponId1 = JacksonUtil.parseInteger(couponId, "couponId");
        int i = couponService.receiveCoupon(couponId1,userId);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrmsg("优惠券已经领取过");
            vo.setErrno(740);
        }
        return vo;
    }
    
    @RequestMapping("wx/coupon/exchange")
    public MessageVo exchange(@RequestBody String code,HttpServletRequest request){
        String code1 = JacksonUtil.parseString(code, "code");
        String header = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(header);
        MessageVo vo = new MessageVo();
        int i = couponService.exchange(code1,userId);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrmsg("优惠券不正确");
            vo.setErrno(742);
        }
        return vo;
    }
}
