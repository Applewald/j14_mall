package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:10
 */

@RestController
public class TopicController {
    @Autowired
    TopicService topicService;
}
