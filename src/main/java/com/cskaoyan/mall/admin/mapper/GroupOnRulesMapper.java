package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.promotion.GOListRecord;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    
    List<GOListRecord> findActivityByTime(@Param("goodsId")Integer goodsId,
                                          @Param("sort")String sort,
                                          @Param("order")String order);
    
    List<Map> getGroupOnList();

    List<GroupOnRules> selectAllGroupOnRules();
    
    List<Map> getMyGroupOnList(@Param("show") int showType);
    
    Map<Object,Object> getMyGroupOnDetail(@Param("id")Integer grouponId);
}