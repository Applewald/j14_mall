package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.DataVo;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 16:58
 * @description
 */
public interface LogService {

    DataVo selectAllLogList(Integer page, Integer limit, String sort, String order, String name);
}
