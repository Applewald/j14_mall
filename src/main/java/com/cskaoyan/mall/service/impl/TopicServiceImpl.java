package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
}
