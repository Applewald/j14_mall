package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.promotion.Topic;
import com.github.pagehelper.PageInfo;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */
public interface TopicService {
    PageInfo<Topic> getAllTopic(int page, int limit, String title, String subtitle, String sort, String order);
    
    int deleteByTopicId(Topic topic);
}
