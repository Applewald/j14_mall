package com.cskaoyan.mall.admin.service.impl;



import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.admin.Admin;
import com.cskaoyan.mall.admin.bean.admin.AdminResp;
import com.cskaoyan.mall.admin.bean.admin.AdminOptions;
import com.cskaoyan.mall.admin.mapper.AdminMapper;
import com.cskaoyan.mall.admin.mapper.RoleMapper;
import com.cskaoyan.mall.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 20:22
 * @description
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin selectByUserName(String username) {
        return adminMapper.selectByUserName(username);
    }

    @Override
    public List<AdminOptions> selectAllRoleIdAndName() {
        return roleMapper.selectAllRoleIdAndName();
    }

    @Override
    public int insert(Admin record) {
        // 用户密码 md5加密
        String password = record.getPassword();
        String md5Password = "123";
        try {
            md5Password = MD5Util.getMD5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        record.setPassword(md5Password);

        return adminMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Admin record) {
        // 用户密码 md5加密
        String password = record.getPassword();
        String md5Password = "123";
        try {
            md5Password = MD5Util.getMD5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        record.setPassword(md5Password);
        return adminMapper.update(record);
    }

    @Override
    public DataVo selectAllAdminList(Integer page, Integer limit, String sort, String order, String username) {
        PageHelper.startPage(page, limit);
        List<AdminResp> admins = adminMapper.selectAllAdmin(sort, order, username);
        PageInfo<AdminResp> pageInfo = new PageInfo<>(admins);

        DataVo<AdminResp> dataVo = new DataVo<>();
        dataVo.setItems(pageInfo.getList());
        dataVo.setTotal(pageInfo.getTotal());
        return dataVo;
    }
}
