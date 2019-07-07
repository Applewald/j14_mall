package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.promotion.Topic;
import com.cskaoyan.mall.service.TopicService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
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
}
