package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.MallSystem;
import com.cskaoyan.mall.mapper.MallSystemMapper;
import com.cskaoyan.mall.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MallSystem> selectOrderConfig() {
        return mallSystemMapper.selectOrderConfig();
    }

    @Override
    public List<MallSystem> selectWxConfig() {
        return mallSystemMapper.selectWxConfig();
    }
    //************************************************

    @Override
    public boolean updateMallSystemBykeyName(Map<String, String> systemMap) {
        for (String keyName : systemMap.keySet()) {
            MallSystem mallSystem = new MallSystem();
            mallSystem.setKeyName(keyName);
            mallSystem.setKeyValue(systemMap.get(keyName));
            mallSystem.setUpdateTime(new Date());
            int update = mallSystemMapper.updateMallSystemBykeyName(mallSystem);
            if (update != 1){
                return false;
            }
        }
        return true;
    }

}
