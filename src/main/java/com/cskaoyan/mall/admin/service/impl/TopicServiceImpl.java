package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.mapper.TopicMapper;
import com.cskaoyan.mall.admin.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
    
    @Override
    public PageInfo<Topic> getAllTopic(int page, int limit, String title, String subtitle, String sort, String order) {
        PageHelper.startPage(page,limit);
        if(title == null){
            title = "";
        }
        if(subtitle == null){
            subtitle = "";
        }
        title = "%" + title + "%";
        subtitle = "%" + subtitle + "%";
        List<Topic> list = topicMapper.getAllTopic(title,subtitle,sort,order);
        PageInfo<Topic> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public int deleteByTopicId(Topic topic) {
        Integer id = topic.getId();
        return topicMapper.deleteByPrimaryKey(id);
    }
}
