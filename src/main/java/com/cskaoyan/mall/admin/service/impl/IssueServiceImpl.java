package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.bean.Issue;
import com.cskaoyan.mall.admin.mapper.IssueMapper;
import com.cskaoyan.mall.admin.service.IssueService;
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
    public ResponseVo findIssueList(int page, int limit, String question, String sort, String order) {
        PageHelper.startPage(page, limit);
        ResponseVo<Object> vo = new ResponseVo<>();
        List<Issue> items = issueMapper.findIssueList(question, sort, order);
        PageInfo<Issue> pageInfo = new PageInfo<>(items);
        DataVo<Issue> issueDataVo = new DataVo<>();
        issueDataVo.setTotal(pageInfo.getTotal());
        issueDataVo.setItems(pageInfo.getList());
        vo.setData(issueDataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
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

    @Override
    public ResponseVo update(Issue issue) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int update = issueMapper.updateByPrimaryKey(issue);
        if (update == 1) {
            vo.setErrno(0);
            vo.setErrmsg("成功");
        } else {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }

    @Override
    public ResponseVo insert(Issue issue) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int insert = issueMapper.insert(issue);
        if (insert == 1) {
            vo.setData(issue);
            vo.setErrno(0);
            vo.setErrmsg("成功");
        }else  {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }
}
