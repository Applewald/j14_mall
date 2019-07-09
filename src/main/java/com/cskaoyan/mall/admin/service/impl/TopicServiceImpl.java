package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.bean.wxhome.TopicList;
import com.cskaoyan.mall.admin.mapper.TopicMapper;
import com.cskaoyan.mall.admin.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    @Override
    public List<TopicList> selectAllTopicList() {
        List<TopicList> temp = topicMapper.selectAllTopicList();
        ArrayList<TopicList> topicLists = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            topicLists.add(temp.get(i));
        }

        return topicLists;
    }



    
    
    /**以下为前台方法*/
    @Override
    public PageInfo<Map> getTopics(int page, int size) {
        PageHelper.startPage(page,size);
        List<Map> list = topicMapper.getTopis();
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public Topic getTopicById(Integer id) {
        return topicMapper.selectByPrimaryKey(id);
    }

}
