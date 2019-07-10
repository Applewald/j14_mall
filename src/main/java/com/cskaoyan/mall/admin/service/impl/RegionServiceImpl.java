package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.RegionChildren;
import com.cskaoyan.mall.admin.mapper.RegionMapper;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public ResponseVo findRegionListByPid(int pid) {
        ResponseVo vo = new ResponseVo();
        List<Map> mapList = regionMapper.findRegionListByPid(pid);
        vo.setData(mapList);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }
}
