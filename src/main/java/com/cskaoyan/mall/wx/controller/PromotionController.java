package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.service.GroupOnService;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.vo.CommentsVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.vo.TopicVo;
import com.cskaoyan.mall.admin.vo.WxDataVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    /*@RequestMapping("wx/comment/list")
    public ResponseVo<CommentsVo> CommentsList(Integer valueId,int type,int showType,int page,int size){
    
    }*/
    
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
    
    /*@RequestMapping("wx/groupon/my")
    public ResponseVo<WxDataVo> groupOnList(int showType){
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
}
