package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.promotion.GroupOnRules;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupOnRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupOnRules record);

    int insertSelective(GroupOnRules record);

    GroupOnRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupOnRules record);

    int updateByPrimaryKey(GroupOnRules record);
    
    List<GroupOnRules> findGroupOnRules(@Param("goodsId") Integer goodsId,
                                        @Param("sort") String sort,
                                        @Param("order") String order);
}