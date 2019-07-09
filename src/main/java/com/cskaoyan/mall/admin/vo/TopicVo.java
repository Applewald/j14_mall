package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.promotion.Topic;

import java.util.List;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/9 11:18
 */
public class TopicVo<T> {
    final String goods = "[]";
    Topic topic;
    
    public String getGoods() {
        return goods;
    }
    
    public Topic getTopic() {
        return topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
