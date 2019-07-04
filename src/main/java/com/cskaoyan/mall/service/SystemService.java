package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.MallSystem;

import java.util.List;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/4 10:38
 */

public interface SystemService {
    List<MallSystem> selectMallSystemByPrefix(String prefix);

    List<MallSystem> selectFreightConfig();
}
