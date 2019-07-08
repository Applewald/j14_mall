package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.mapper.AddressMapper;
import com.cskaoyan.mall.admin.vo.PageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public ResponseVo<PageVo<Address>> list1(int page, int limit, String sort, String order, String name, String userId) {
        PageHelper.startPage(page,limit);
        List<Address> addresses = addressMapper.queryAddressByOrder(name,userId,sort,order);
        PageInfo<Address> addressPageInfo = new PageInfo<>(addresses);
        PageVo<Address> addresslist= new PageVo<>( (int)addressPageInfo.getTotal(),addressPageInfo.getList());

        ResponseVo<PageVo<Address>> pageVoResponseVo = new ResponseVo<>();
        if((int)addressPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(addresslist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }
}
