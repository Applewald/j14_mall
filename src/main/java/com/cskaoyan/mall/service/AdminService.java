package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.admin.Admin;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import com.cskaoyan.mall.vo.DataVo;


import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 20:22
 * @description
 */
public interface AdminService {

    Admin selectByPrimaryKey(Integer id);

    Admin selectByUserName(String username);

    List<AdminOptions> selectAllRoleIdAndName();

    int insert(Admin record);

    int deleteByPrimaryKey(Integer id);

    DataVo selectAllAdminList(Integer page, Integer limit, String sort, String order, String username);
}
