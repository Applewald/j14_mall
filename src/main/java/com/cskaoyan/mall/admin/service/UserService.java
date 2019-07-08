package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.vo.PageVo;

/**
 * author : summer
 * date 2019/7/3 20:58
 */
public interface UserService {


    //ResponseVo<PageVo<User>> list(int page,int limit,String sort,String order);
    ResponseVo<PageVo<User>> list1(int page, int limit, String sort, String order, String username, String mobile);


    int userTotal();
}
