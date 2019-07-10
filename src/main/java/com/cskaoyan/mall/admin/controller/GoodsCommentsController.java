package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.GoodsComment;
import com.cskaoyan.mall.admin.service.GoodsCommentService;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.MessageVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
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


    @RequestMapping("comment/delete")
    public Object deletedComment(@RequestBody GoodsComment comment){
        goodsCommentService.deleteGoodsComent(comment);
        return MessageVo.getSuccessMeg();
    }
}
