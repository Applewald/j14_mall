package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author lixiaolong
 * date: 2019-07-04 21:17
 * description:
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public ResponseVo insert(Storage storage) {
        ResponseVo<Storage> vo = new ResponseVo<>();
        int insert = storageMapper.insert(storage);
        if (insert == 1) {
            vo.setErrno(0);
            vo.setData(storage);
            vo.setErrmsg("成功");
            vo.setData(storage);
        }
        return vo;
    }
}
