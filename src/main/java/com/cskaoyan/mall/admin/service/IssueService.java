package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Issue;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface IssueService {

    ResponseVo findIssueList(int page, int limit, String question, String sort, String order);

    ResponseVo delete(int id);

    ResponseVo update(Issue issue);

    ResponseVo insert(Issue issue);
}
