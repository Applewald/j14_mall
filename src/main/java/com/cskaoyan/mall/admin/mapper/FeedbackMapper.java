package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.bean.FeedbackExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
    List<Feedback> queryFeedbackByOrder(@Param("username")String username,
                                 @Param("id")String id,
                                 @Param("sort")String sort,
                                 @Param("order")String order);

    Map submitFeedBack();
}