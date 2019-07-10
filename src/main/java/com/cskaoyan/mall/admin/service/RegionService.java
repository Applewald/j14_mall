package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.RegionChildren;
import com.cskaoyan.mall.admin.vo.ResponseVo;

import java.util.List;

/**
 * author: xiaolong
 * date: 2019-07-03 21:14
 * version: 1.0
 * description:
 */
public interface RegionService {

    List<RegionChildren> findRegionList();

    ResponseVo findRegionListByPid(int pid);
}
