package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.log.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {

    List<Log> selectAllLogList(@Param("sort") String sort, @Param("order") String order, @Param("admin") String name);

    void insert(@Param("log") Log log);
}