package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionChildren;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author lixiaolong
 * date: 2019-07-03 21:14
 * description:
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<RegionChildren> findRegionList() {
        return regionMapper.findRegionList();
    }
}
