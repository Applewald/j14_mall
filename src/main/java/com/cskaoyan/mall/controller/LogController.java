package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.LogService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 17:01
 * @description 系统管理 - 操作日志 - controller层
 */

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService;

    /*查询操作日志*/
    @GetMapping("/list")
    public Object logList(Integer page, Integer limit, String sort, String order, String name) {
        DataVo dataVo = logService.selectAllLogList(page, limit, sort, order, name);
        return ResponseVo.ok(dataVo);
    }
}
