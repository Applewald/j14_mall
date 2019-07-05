package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.vo.ReVo;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 20:22
 * @description
 */
public interface AdminService {



    ReVo selectAllAdmin(Integer page, Integer limit, String sort, String order);
}
