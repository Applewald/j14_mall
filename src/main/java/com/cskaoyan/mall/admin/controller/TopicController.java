package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.service.TopicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */

@RestController
@RequestMapping("admin")
public class TopicController {
    @Autowired
    TopicService topicService;
    
    @RequestMapping("topic/list")
    public ResponseVo<DataVo> list(int page, int limit, String title, String subtitle, String sort, String order){
        ResponseVo<DataVo> vo = new ResponseVo<>();
        DataVo<Topic> dataVo = new DataVo<>();
        PageInfo<Topic> pageInfo = topicService.getAllTopic(page,limit,title,subtitle,sort,order);
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        vo.setErrno(0);
        vo.setData(dataVo);
        vo.setErrmsg("成功");
        return vo;
    }
    
    @RequestMapping("topic/delete")
    public ResponseVo<Topic> delete(@RequestBody Topic topic){
        ResponseVo<Topic> vo = new ResponseVo<>();
        int i = topicService.deleteByTopicId(topic);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("成功");
        } else {
            vo.setErrmsg("失败");
        }
        return vo;
    }
    
    @RequestMapping("topic/create")
    public ResponseVo<Topic> create(@RequestBody Topic topic){
        ResponseVo<Topic> vo = new ResponseVo<>();
        int i = topicService.insert(topic);
        vo.setData(topic);
        if(i > 0){
            vo.setErrno(0);
            vo.setErrmsg("OK");
        } else {
            vo.setErrmsg("失败");
            vo.setErrno(500);
        }
        return vo;
    }
    
    @RequestMapping("topic/update")
    public ResponseVo<Topic> update(@RequestBody Topic topic){
        ResponseVo<Topic> vo = new ResponseVo<>();
        int i = topicService.updateById(topic);
        vo.setData(topic);
        if(i > 0){
            vo.setErrmsg("成功");
            vo.setErrno(0);
        } else {
            vo.setErrno(500);
            vo.setErrmsg("失败");
        }
        return vo;
    }
}
