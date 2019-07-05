package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/3 20:58
 */
public interface UserService {


    ResponseVo<PageVo<User>> list(int page,int limit,String sort,String order);

    int userTotal();
}
