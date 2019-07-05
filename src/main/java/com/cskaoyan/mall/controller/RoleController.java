package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.ReceiveRole;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.service.RoleService;
import com.cskaoyan.mall.vo.ReVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author zzc
 * @version 1.0
 * @date 2019-07-03 17:45
 * @description
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("role/options")
    public ReVo roleOptions() {
        ReVo reVo = new ReVo();
        reVo.setErrmsg("成功");
        reVo.setErrno(0);
        return reVo;
    }

    /*查询全部的角色, 附带模糊查询*/
    @RequestMapping("role/list")
    public ReVo roleList(Integer page, Integer limit, String sort, String order, String name) {
        return roleService.selectAllRole(page, limit, sort, order, name);
    }

    /*添加新的角色*/
    @RequestMapping("role/create")
    public ResponseVo create(Map<String,String> map) {



        /*Role role = new Role();
        role.setName(map.get("name"));
        role.setDesc(map.get("desc"));*/
        ResponseVo responseVo = new ResponseVo();
        return responseVo;
    }
}
