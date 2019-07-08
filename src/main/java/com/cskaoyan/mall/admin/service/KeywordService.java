package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Keyword;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface KeywordService {

    ResponseVo findKeywordList(int page, int limit, String keyword, String url, String sort, String order);

    ResponseVo delete(int id);

    ResponseVo update(Keyword keyword);

    ResponseVo insert(Keyword keyword);
}
