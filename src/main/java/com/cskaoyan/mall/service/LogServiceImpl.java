package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.log.Log;
import com.cskaoyan.mall.mapper.LogMapper;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 16:59
 * @description 系统管理 - 操作日志 - service层
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public DataVo selectAllLogList(Integer page, Integer limit, String sort, String order, String name) {
        PageHelper.startPage(page, limit);
        List<Log> logs = logMapper.selectAllLogList(sort, order, name);
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        DataVo<Log> dataVo = new DataVo<>();
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        return dataVo;
    }
}
