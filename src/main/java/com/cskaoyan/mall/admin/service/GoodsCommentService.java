package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.GoodsComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsCommentService {

    DataVo<GoodsComment> findGoodsComments(int page, int limit, String sort, String order, String userId, String valueId);

    List<Object> selectAllCommentsList(Integer valueId, Integer type, Integer size, Integer page, Integer showType);
}

