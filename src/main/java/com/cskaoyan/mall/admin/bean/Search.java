package com.cskaoyan.mall.admin.bean;

import java.util.List;

/**
 * author : summer
 * date 2019/7/9 20:59
 */
public class Search {
   SearchHistory defaultKeyword;
   List<Keyword > historyKeywordList;
   List<Keyword > hotKeywordList;

    public SearchHistory getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(SearchHistory defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<Keyword> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<Keyword> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<Keyword> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<Keyword> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    public Search() {
    }

    public Search(SearchHistory defaultKeyword, List<Keyword> historyKeywordList, List<Keyword> hotKeywordList) {
        this.defaultKeyword = defaultKeyword;
        this.historyKeywordList = historyKeywordList;
        this.hotKeywordList = hotKeywordList;
    }
}
