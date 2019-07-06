package com.cskaoyan.mall.service.impl;


import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.mapper.FeedbackMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.FeedbackService;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.vo.PageVo;
import com.cskaoyan.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : summer
 * date 2019/7/3 20:57
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public ResponseVo<PageVo<Feedback>> list1(int page, int limit, String sort, String order, String username, String id) {
        PageHelper.startPage(page,limit);
        List<Feedback> feedbacks = feedbackMapper.queryFeedbackByOrder(username,id,sort,order);

        PageInfo<Feedback> feedbackPageInfo = new PageInfo<>(feedbacks);

        PageVo<Feedback> feedbacklist= new PageVo<>( (int)feedbackPageInfo.getTotal(),feedbackPageInfo.getList());

        ResponseVo<PageVo<Feedback>> pageVoResponseVo = new ResponseVo<>();
        if((int)feedbackPageInfo.getTotal() > -1) {
            pageVoResponseVo.setData(feedbacklist);
            pageVoResponseVo.setErrmsg("成功");
            pageVoResponseVo.setErrno(0);
        } else {
            pageVoResponseVo.setErrmsg(null);
            pageVoResponseVo.setErrmsg("失败");
            pageVoResponseVo.setErrno(-1);
        }
        return pageVoResponseVo;
    }
}
