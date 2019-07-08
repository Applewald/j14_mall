package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;

/**
 * author : summer
 * date 2019/7/3 20:58
 */
public interface AddressService {

    ResponseVo<PageVo<Address>> list1(int page, int limit,String name, String userId, String sort, String order);

    ResponseVo<Address> getAddressList();
}
