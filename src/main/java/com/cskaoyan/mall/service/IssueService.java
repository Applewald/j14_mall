package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface IssueService {

    DataVo<Issue> findIssueList(int page, int limit, String question, String sort, String order);

    ResponseVo delete(int id);
}
