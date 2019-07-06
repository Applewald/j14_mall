package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/4 20:39
 */
public interface SearchHistoryService {
    ResponseVo<PageVo<SearchHistory>> list1(int page, int limit, String sort, String order, String userId, String keyword);
}
