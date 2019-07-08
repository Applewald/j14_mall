package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.log.Log;
import com.cskaoyan.mall.vo.DataVo;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 16:58
 * @description
 */
public interface LogService {

    DataVo selectAllLogList(Integer page, Integer limit, String sort, String order, String name);

    void save(Log log);
}
