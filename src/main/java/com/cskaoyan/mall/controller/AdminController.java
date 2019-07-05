package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.Data;
import com.cskaoyan.mall.vo.ReVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-04 15:54
 * @description
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("admin/list")
    @ResponseBody
    public ReVo adminList(Integer page, Integer limit, String sort, String order) {

        ReVo reVo = adminService.selectAllAdmin(page, limit, sort, order);
        return reVo;

    }
}
