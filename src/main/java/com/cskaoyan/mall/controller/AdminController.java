package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.admin.Admin;
import com.cskaoyan.mall.bean.admin.AdminResp;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 15:54
 * @description
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @RequestMapping("/list")
    public Object adminList(Integer page, Integer limit, String sort, String order, String username) {
        DataVo dataVo = adminService.selectAllAdminList(page, limit, sort, order, username);
        Object ok = ResponseVo.ok(dataVo);
        return ok;
    }

    /*添加管理员*/
    @RequestMapping("/create")
    public Object insert(@RequestBody Admin admin) {
        // 检查密码长度

        // 检查数据库是否有同名的管理员
        System.out.println("-------------------");
        // 没有问题就添加
        adminService.insert(admin);

        Admin admin1 = adminService.selectByUserName(admin.getUsername());

        return ResponseVo.ok(admin1);
    }

    /*删除管理员*/
    @RequestMapping("/delete")
    public Object delete(@RequestBody Admin admin) {
        adminService.deleteByPrimaryKey(admin.getId());
        return ResponseVo.ok();
    }

    /*修改管理员*/
    @RequestMapping("/update")
    public Object update(@RequestBody AdminResp adminResp) {
        int id = adminResp.getId();


        return ResponseVo.ok();
    }


}
