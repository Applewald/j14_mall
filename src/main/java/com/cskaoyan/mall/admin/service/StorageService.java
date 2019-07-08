package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.storage.Storage;

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
