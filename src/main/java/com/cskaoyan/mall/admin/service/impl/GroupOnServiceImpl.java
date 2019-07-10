package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.promotion.GOListRecord;
import com.cskaoyan.mall.admin.bean.promotion.GroupOnRules;
import com.cskaoyan.mall.admin.mapper.GroupOnMapper;
import com.cskaoyan.mall.admin.mapper.GroupOnRulesMapper;
import com.cskaoyan.mall.admin.service.GroupOnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 20:38
 */
@Service
public class GroupOnServiceImpl implements GroupOnService {
    @Autowired
    GroupOnMapper groupOnMapper;
    @Autowired
    GroupOnRulesMapper groupOnRulesMapper;
    
    @Override
    public PageInfo<GroupOnRules> findGroupOnRules(int page, int limit, Integer goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<GroupOnRules> list = groupOnRulesMapper.findGroupOnRules(goodsId,sort,order);
        PageInfo<GroupOnRules> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    @Override
    public int deleteByGroupOnRulesId(GroupOnRules groupOnRules) {
        Integer id = groupOnRules.getId();
        return groupOnRulesMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int updateById(GroupOnRules groupOnRules) {
        return groupOnRulesMapper.updateByPrimaryKey(groupOnRules);
    }
    
    @Override
    public PageInfo<GOListRecord> findActivity(int page, int limit, Integer goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<GOListRecord> list = groupOnRulesMapper.findActivityByTime(goodsId,sort,order);
        PageInfo<GOListRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~以下为前台部分~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public PageInfo<Map> getGroupOnList(int page, int size) {
        PageHelper.startPage(page,size);
        List<Map> list =  groupOnRulesMapper.getGroupOnList();
        return new PageInfo<>(list);
    }
    
    @Override
    public List<Map> getMyGroupOnList(int showType) {
        List<Map> list = groupOnRulesMapper.getMyGroupOnList(showType);
        boolean flag;
        for (Map map:list) {
            Long isCreator = (Long) map.get("isCreator");
            if(isCreator == 0){
                flag = false;
            } else {
                flag = true;
            }
            System.out.println(isCreator);
            System.out.println(flag);
            map.put("isCreator",flag);
        }
        return list;
    }
    
    @Override
    public Map<Object,Object> getMyGroupOnDetail(Integer grouponId) {
        Map<Object,Object> list = groupOnRulesMapper.getMyGroupOnDetail(grouponId);
        return list;
    }
}
