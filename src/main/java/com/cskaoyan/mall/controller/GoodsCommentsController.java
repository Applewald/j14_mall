package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.GoodsComment;
import com.cskaoyan.mall.service.GoodsCommentService;
import com.cskaoyan.mall.vo.DataVo;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsCommentsController {


    @Autowired
    GoodsCommentService goodsCommentService;

    @RequestMapping("comment/list")
    public ResponseVo<DataVo<GoodsComment>>findGoodsComments(int page , int limit,String order ,String sort, String userId,String valueId){
        DataVo<GoodsComment> comments = goodsCommentService.findGoodsComments(page,limit,sort,order,userId,valueId);
        ResponseVo<DataVo<GoodsComment>> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(comments);
        return responseVo;
    }
}
