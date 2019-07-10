package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Search;
import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/4 20:39
 */
public interface SearchHistoryService {
    ResponseVo<PageVo<SearchHistory>> list1(int page, int limit, String sort, String order, String userId, String keyword);

    Search querySearchHistory(Integer userId);
}
