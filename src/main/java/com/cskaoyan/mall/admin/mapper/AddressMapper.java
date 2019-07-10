package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.AddressExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    //自己写的查询方法

    List<Address> queryAddressByOrder(@Param("name")String name,
                                      @Param("userId")String userId,
                                      @Param("sort")String sort,
                                      @Param("order")String order);

    @Select("select * from cskaoyan_mall_address where user_id = #{userId} and is_default = 1 and deleted = 0  ")
    Address findDefaultAddress(@Param("userId") Integer userId);


    @Select("select * from cskaoyan_mall_address where id = #{id} and  deleted = 0  ")
    Address findAddressById(@Param("id") Integer addressId);
}