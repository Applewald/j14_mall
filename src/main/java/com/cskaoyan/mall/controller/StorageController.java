package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.storage.Storage;
import com.cskaoyan.mall.mapper.CreateStorgeMapper;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 19:13
 * @description
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    /*查询*/
    @GetMapping("/list")
    public Object storageList(Integer page, Integer limit, String sort, String order, String key, String name) {
        DataVo dataVo = storageService.selectAllStorageList(page, limit, sort, order, key, name);
        return ResponseVo.ok(dataVo);
    }

    /*删除*/
    @PostMapping("/delete")
    public Object storageDelete(@RequestBody Storage storage) {
        storageService.deleteById(storage.getId());
        return ResponseVo.ok();
    }

    /*修改*/
    @PostMapping("/update")
    public Object storageUpdate(@RequestBody Storage storage) {
        storageService.updateByStorage(storage);
        return ResponseVo.ok();
    }
}
