package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.promotion.GroupOn;
import com.cskaoyan.mall.bean.promotion.GroupOnRules;
import com.cskaoyan.mall.mapper.GroupOnMapper;
import com.cskaoyan.mall.mapper.GroupOnRulesMapper;
import com.cskaoyan.mall.service.GroupOnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
