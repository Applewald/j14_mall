package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.promotion.GroupOn;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupOn record);

    int insertSelective(GroupOn record);

    GroupOn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupOn record);

    int updateByPrimaryKey(GroupOn record);
}