package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.service.IssueService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
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
        DataVo<Issue> issueDataVo = issueService.findIssueList(page, limit, question, sort, order);
        ResponseVo<DataVo<Issue>> dataVoResponse = new ResponseVo<>();
        dataVoResponse.setErrno(0);
        dataVoResponse.setErrmsg("成功");
        dataVoResponse.setData(issueDataVo);
        return dataVoResponse;
    }

    /*@RequestMapping("brand/list")
    public ResponseVo brandList(int page, int limit, Integer id, String name, String sort, String order) {
        ResponseVo<DataVo<Brand>> vo = new ResponseVo<>();
        DataVo<Brand> dataVo = brandService.findBrandList(page, limit, id, name, sort, order);
        vo.setData(dataVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }*/
}
