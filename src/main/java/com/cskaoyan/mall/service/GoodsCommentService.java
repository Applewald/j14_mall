package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.GoodsComment;
import com.cskaoyan.mall.vo.DataVo;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsCommentService {
    DataVo<GoodsComment> findGoodsComments(int page, int limit, String sort, String order, String userId, String valueId);
}

