package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.log.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {

    List<Log> selectAllLogList(@Param("sort") String sort, @Param("order") String order, @Param("admin") String name);
}