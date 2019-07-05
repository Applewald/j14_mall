package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.mapper.IssueMapper;
import com.cskaoyan.mall.service.IssueService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {


    @Autowired
    IssueMapper issueMapper;

    @Override
    public DataVo<Issue> findIssueList(int page, int limit, String question, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Issue> items = issueMapper.findIssueList(question, sort, order);
        PageInfo<Issue> pageInfo = new PageInfo<>(items);
        DataVo<Issue> issueDataVo = new DataVo<>();
        issueDataVo.setTotal(pageInfo.getTotal());
        issueDataVo.setItems(pageInfo.getList());
        return issueDataVo;
    }

    @Override
    public ResponseVo delete(int id) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int delete = issueMapper.deleteByPrimaryKey(id);
        if (delete == 1) {
            vo.setErrno(0);
            vo.setErrmsg("成功");
        } else {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }
}
