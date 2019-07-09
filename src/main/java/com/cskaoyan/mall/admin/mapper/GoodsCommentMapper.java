package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.GoodsComment;
import com.cskaoyan.mall.admin.bean.WxComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCommentMapper {
    List<GoodsComment> findComments(@Param("sort") String sort,@Param("order") String order,@Param("userId") String userId,@Param("valueId") String valueId);

    List<WxComment> findGoodsCommentByValueId(@Param("valueId") Integer id);
}
