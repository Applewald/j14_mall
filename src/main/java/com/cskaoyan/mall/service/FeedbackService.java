package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/4 20:39
 */
public interface FeedbackService {
    ResponseVo<PageVo<Feedback>> list1(int page, int limit, String sort, String order, String username, String id);
}
