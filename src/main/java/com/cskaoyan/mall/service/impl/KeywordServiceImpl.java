package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.mapper.KeywordMapper;
import com.cskaoyan.mall.service.KeywordService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {


    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public ResponseVo findKeywordList(int page, int limit, String keyword,String url, String sort, String order) {
        PageHelper.startPage(page, limit);
        ResponseVo<Object> vo = new ResponseVo<>();
        List<Keyword> items = keywordMapper.findKeywordList(keyword,url, sort, order);
        PageInfo<Keyword> pageInfo = new PageInfo<>(items);
        DataVo<Keyword> keywordDataVo = new DataVo<>();
        keywordDataVo.setTotal(pageInfo.getTotal());
        keywordDataVo.setItems(pageInfo.getList());
        vo.setData(keywordDataVo);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return vo;
    }

    @Override
    public ResponseVo delete(int id) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int delete = keywordMapper.deleteByPrimaryKey(id);
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
    public ResponseVo update(Keyword keyword) {
        ResponseVo<Object> vo = new ResponseVo<>();
        int update = keywordMapper.updateByPrimaryKey(keyword);
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
    public ResponseVo insert(Keyword keyword) {
        ResponseVo<Object> vo = new ResponseVo<>();
        keyword.setSortOrder(0);
        int insert = keywordMapper.insert(keyword);
        if (insert == 1) {
            vo.setData(keyword);
            vo.setErrno(0);
            vo.setErrmsg("成功");
        }else  {
            vo.setErrno(-1);
            vo.setErrmsg("失败");
        }
        return vo;
    }
}
