package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.promotion.GOListRecord;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 20:38
 */
public interface GroupOnService {
    PageInfo<GroupOnRules> findGroupOnRules(int page, int limit, Integer goodsId, String sort, String order);
    
    int deleteByGroupOnRulesId(GroupOnRules groupOnRules);
    
    int updateById(GroupOnRules groupOnRules);
    
    PageInfo<GOListRecord> findActivity(int page, int limit, Integer goodsId, String sort, String order);
    
    PageInfo<Map> getGroupOnList(int page, int size);
    
    List<Map> getMyGroupOnList(int showType);
    
    Map<Object,Object> getMyGroupOnDetail(Integer grouponId);
}
