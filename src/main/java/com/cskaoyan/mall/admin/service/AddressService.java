package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/3 20:58
 */
public interface AddressService {

    ResponseVo<PageVo<Address>> list1(int page, int limit,String name, String userId, String sort, String order);
}
