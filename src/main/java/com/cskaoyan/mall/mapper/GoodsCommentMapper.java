package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GoodsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCommentMapper {
    List<GoodsComment> findComments(@Param("sort") String sort,@Param("order") String order,@Param("userId") String userId,@Param("valueId") String valueId);
}
