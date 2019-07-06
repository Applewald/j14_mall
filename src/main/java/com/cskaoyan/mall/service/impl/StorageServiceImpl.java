package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.storage.Storage;
import com.cskaoyan.mall.mapper.CreateStorgeMapper;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.DataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 19:18
 * @description
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    CreateStorgeMapper createStorgeMapper;

    @Override
    public int deleteById(Integer id) {
        return createStorgeMapper.deleteById(id);
    }

    @Override
    public int updateByStorage(Storage storage) {
        return createStorgeMapper.updateByStorage(storage);
    }


    @Override
    public DataVo selectAllStorageList(Integer page, Integer limit, String sort, String order, String key, String name) {
        PageHelper.startPage(page, limit);
        List<Storage> storages = createStorgeMapper.selectAllStorageList(sort, order, key, name);
        PageInfo<Storage> pageInfo = new PageInfo<>(storages);
        DataVo dataVo = new DataVo();
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        return dataVo;
    }
}
