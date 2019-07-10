package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.GoodsComment;
import com.cskaoyan.mall.admin.bean.WxComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface GoodsCommentMapper {

    List<GoodsComment> findComments(@Param("sort") String sort,@Param("order") String order,@Param("userId") String userId,@Param("valueId") String valueId);


    List<GoodsComment> selectAllCommentsList(@Param("valueId") Integer valueId, @Param("type") Integer type);

    List<WxComment> findGoodsCommentByValueId(@Param("valueId") Integer id);


    void insert(@Param("comment") GoodsComment comment);

    @Delete("delete from cskaoyan_mall_comment where id = #{id}")
    void deletebyId(@Param("id") Integer id);
}
