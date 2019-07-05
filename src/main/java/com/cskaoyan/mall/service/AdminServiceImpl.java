package com.cskaoyan.mall.service;



import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminResp;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.vo.Data;
import com.cskaoyan.mall.vo.ReVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ReVo selectAllAdmin(Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<AdminResp> admins = adminMapper.selectAllAdmin();
        PageInfo<AdminResp> pageInfo = new PageInfo<>(admins);

        Data<AdminResp> adminData = new Data<>(pageInfo.getList(), pageInfo.getTotal());

        ReVo reVo = new ReVo(adminData, "成功", 0);
        return reVo;
    }
}
