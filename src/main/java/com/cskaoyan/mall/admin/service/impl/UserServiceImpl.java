package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.service.UserService;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import com.cskaoyan.mall.admin.mapper.UserMapper;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : summer
 * date 2019/7/3 20:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /*@Override
    public ResponseVo<PageVo<User>> list(int page, int limit, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<User> users = userMapper.queryUsers(sort,order);
        PageInfo<User> userPageInfo = new PageInfo<>(users);

        PageVo<User> userlist= new PageVo<>( (int)userPageInfo.getTotal(),userPageInfo.getList());

        ResponseVo<PageVo<User>> pageVoResponseVo = new ResponseVo<>();
        if(limit > -1) {
            pageVoResponseVo.setData(userlist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }*/

    @Override
    public ResponseVo<PageVo<User>> list1(int page, int limit, String sort, String order, String username, String mobile) {
        PageHelper.startPage(page,limit);
        List<User> users = userMapper.queryUsersByOrder(username,mobile,sort,order);
        PageInfo<User> userPageInfo = new PageInfo<>(users);

        PageVo<User> userlist= new PageVo<>( (int)userPageInfo.getTotal(),userPageInfo.getList());

        ResponseVo<PageVo<User>> pageVoResponseVo = new ResponseVo<>();
        if((int)userPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(userlist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }

    @Override
    public int userTotal() {
        return userMapper.userTotal();
    }


    @Override
    public User findUserInfoByUsernameAndPassword(String username, String password) {
        return userMapper.findUserInfoByUsernameAndPassword(username,password);
    }
}
