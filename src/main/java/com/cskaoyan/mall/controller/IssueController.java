package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.service.IssueService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @RequestMapping("list")
    public ResponseVo issueList(int page, int limit, String question, String sort, String order) {
        ResponseVo<DataVo<Issue>> vo = issueService.findIssueList(page, limit, question, sort, order);
        return vo;
    }
    @RequestMapping("delete")
    public ResponseVo issueDelete(@RequestBody Issue issue) {
        ResponseVo<DataVo<Issue>> vo = issueService.delete(issue.getId());
        return vo;
    }
    @RequestMapping("update")
    public ResponseVo issueUpdate(@RequestBody Issue issue) {
        ResponseVo<String> vo = issueService.update(issue);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVo issueCreate(@RequestBody Issue issue) {
        ResponseVo<String> vo = issueService.insert(issue);
        return vo;
    }
}
