package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.vo.ReVo;
import com.cskaoyan.mall.vo.ResponseVo;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 22:19
 * @description
 */
public interface RoleService {

    ResponseVo insert(Role record);

    ReVo selectAllRole(Integer page, Integer limit, String sort, String order, String name);
}
