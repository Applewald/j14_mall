package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.bean.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    //逆向工程生成
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //自己写的查询方法

    //List<User> queryUsers(@Param("sort") String sort,@Param("order") String order);
    List<User> queryUsersByOrder(@Param("username")String username,
                                 @Param("mobile")String mobile,
                                 @Param("sort")String sort,
                                 @Param("order")String order);

    List<User> queryUsers(@Param("sort") String sort,@Param("order") String order);

    int userTotal();

    User findUserInfoByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}