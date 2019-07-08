package com.cskaoyan.mall.bean.promotion;

import com.cskaoyan.mall.bean.Goods;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/7 22:50
 */
public class GOListRecord {
    
    private Goods goods;
    
    private GroupOn groupon;
    
    private GroupOnRules rules;
    
    final String subGroupons = "[]";
    
    public Goods getGoods() {
        return goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    
    public GroupOn getGroupon() {
        return groupon;
    }
    
    public void setGroupon(GroupOn groupon) {
        this.groupon = groupon;
    }
    
    public GroupOnRules getRules() {
        return rules;
    }
    
    public void setRules(GroupOnRules rules) {
        this.rules = rules;
    }
    
    public String getSubGroupons() {
        return subGroupons;
    }
    
}
