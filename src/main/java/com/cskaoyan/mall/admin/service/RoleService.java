package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.role.Role;
import com.cskaoyan.mall.admin.bean.admin.AdminOptions;


import java.util.List;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 22:19
 * @description
 */
public interface RoleService {

    int insertByRole(Role role);

    int deleteById(Integer id);

    int updateByRole(Role role);

    Role selectRoleByName(String name);

    List<AdminOptions> selectAllRoleIdAndName();

    DataVo selectAllRoleList(Integer page, Integer limit, String sort, String order, String name);

}
