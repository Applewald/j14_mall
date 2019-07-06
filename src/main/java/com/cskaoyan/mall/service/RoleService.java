package com.cskaoyan.mall.service;


import com.cskaoyan.mall.bean.role.Role;
import com.cskaoyan.mall.bean.admin.AdminOptions;
import com.cskaoyan.mall.vo.DataVo;


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
