package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/4 20:39
 */
public interface FeedbackService {
    ResponseVo<PageVo<Feedback>> list1(int page, int limit, String sort, String order, String username, String id);
}
