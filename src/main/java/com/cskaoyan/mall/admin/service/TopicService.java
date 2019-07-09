package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import com.cskaoyan.mall.admin.bean.wxhome.TopicList;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */
public interface TopicService {
    PageInfo<Topic> getAllTopic(int page, int limit, String title, String subtitle, String sort, String order);
    
    int deleteByTopicId(Topic topic);

    List<TopicList> selectAllTopicList();
}
