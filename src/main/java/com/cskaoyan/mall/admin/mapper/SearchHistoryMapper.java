package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.bean.SearchHistoryExample;
import com.cskaoyan.mall.admin.bean.SearchHotHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByExample(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> querySearchHistoryByOrder(@Param("userId")String userId,
                                                  @Param("keyword")String keyword,
                                                  @Param("sort")String sort,
                                                  @Param("order")String order);

    SearchHistory querySearchHistory();

    List<Keyword> queryHistoryByKeyword(Integer userId);

    List<Keyword> querySearchHotHistory();
}