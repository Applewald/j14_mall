package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.MallSystem;
import com.cskaoyan.mall.mapper.MallSystemMapper;
import com.cskaoyan.mall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/4 10:40
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    MallSystemMapper mallSystemMapper;

    @Override
    public List<MallSystem> selectMallSystemByPrefix(String prefix) {
        String s = "%" +prefix+"%";
        return mallSystemMapper.selectMallSystem(s);
    }

    @Override
    public List<MallSystem> selectFreightConfig() {
        return mallSystemMapper.selectFreightSystem();
    }
}
