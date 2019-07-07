package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.storage.Storage;
import com.cskaoyan.mall.vo.DataVo;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-06 19:18
 * @description
 */
public interface StorageService {

    int deleteById(Integer id);

    int updateByStorage(Storage storage);

    DataVo selectAllStorageList(Integer page, Integer limit, String sort, String order, String key, String name);
}
