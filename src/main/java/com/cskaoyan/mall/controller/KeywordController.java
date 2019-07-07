package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.service.KeywordService;
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
@RequestMapping("keyword")
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    @RequestMapping("list")
    public ResponseVo keywordList(int page, int limit, String keyword,String url, String sort, String order) {
        ResponseVo<DataVo<Keyword>> vo = keywordService.findKeywordList(page, limit, keyword,url, sort, order);
        return vo;
    }
    @RequestMapping("delete")
    public ResponseVo keywordDelete(@RequestBody Keyword keyword) {
        ResponseVo<DataVo<Keyword>> vo = keywordService.delete(keyword.getId());
        return vo;
    }
    @RequestMapping("update")
    public ResponseVo keywordUpdate(@RequestBody Keyword keyword) {
        ResponseVo<String> vo = keywordService.update(keyword);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVo keywordCreate(@RequestBody Keyword keyword) {
        ResponseVo<String> vo = keywordService.insert(keyword);
        return vo;
    }
}
