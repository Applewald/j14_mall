package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.service.SearchHistoryService;
import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : summer
 * date 2019/7/3 20:57
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public ResponseVo<PageVo<SearchHistory>> list1(int page, int limit,String sort, String order,String userId,String keyword) {
        PageHelper.startPage(page,limit);
        List<SearchHistory> searchHistories = searchHistoryMapper.querySearchHistoryByOrder(userId,keyword,sort,order);
        PageInfo<SearchHistory> searchHistoryPageInfo = new PageInfo<>(searchHistories);

        PageVo<SearchHistory> searchHistorylist= new PageVo<>( (int)searchHistoryPageInfo.getTotal(),searchHistoryPageInfo.getList());

        ResponseVo<PageVo<SearchHistory>> pageVoResponseVo = new ResponseVo<>();
        if((int)searchHistoryPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(searchHistorylist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }
}
