package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.mapper.UserMapper;
import com.cskaoyan.mall.admin.service.GoodsCommentService;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.bean.GoodsComment;
import com.cskaoyan.mall.admin.mapper.GoodsCommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    GoodsCommentMapper goodsCommentMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public DataVo<GoodsComment> findGoodsComments(int page, int limit, String sort, String order, String userId, String valueId) {
        PageHelper.startPage(page,limit);
        List<GoodsComment> items =  goodsCommentMapper.findComments(sort,order,userId,valueId);
        PageInfo<GoodsComment> pageInfo = new PageInfo<>(items);
        DataVo<GoodsComment> goodsCommentDataVo = new DataVo<>();
        goodsCommentDataVo.setTotal(pageInfo.getTotal());
        goodsCommentDataVo.setItems(pageInfo.getList());
        return goodsCommentDataVo;

    }

    @Override
    public List<Object> selectAllCommentsList(Integer valueId, Integer type, Integer size, Integer page, Integer showType) {

        List<Object> dataLists = new ArrayList<>();

        PageHelper.startPage(page, size);

        // 默认无图
        List<GoodsComment> goodsComments = goodsCommentMapper.selectAllCommentsList(valueId, type);

        // 如果有图
        if (showType == 1) {

            // 筛选有图的
            List<GoodsComment> showType1 = new ArrayList<>();

            for (GoodsComment goodsComment : goodsComments) {
                if (!"[]".equals(goodsComment.getPicUrls())) {
                    showType1.add(goodsComment);
                }
            }

            for (GoodsComment goodsComment : showType1) {

                Map<Object, Object> map = new HashMap<>();

                User user = userMapper.selectByPrimaryKey(goodsComment.getUserId());

                Map<Object, Object> userInfoMap = new HashMap<>();
                userInfoMap.put("nickName", user.getNickname());
                userInfoMap.put("avatarUrl", user.getAvatar());

                String[] picUrls = goodsComment.getPicUrls();

                map.put("addTime", goodsComment.getAddTime());
                map.put("content", goodsComment.getContent());
                map.put("picList", picUrls);
                map.put("userInfo", userInfoMap);

                dataLists.add(map);
            }
        } else {

            for (GoodsComment goodsComment : goodsComments) {
                Map<Object, Object> map = new HashMap<>();

                User user = userMapper.selectByPrimaryKey(goodsComment.getUserId());

                Map<Object, Object> userInfoMap = new HashMap<>();
                userInfoMap.put("nickName", user.getNickname());
                userInfoMap.put("avatarUrl", user.getAvatar());

                String[] picUrls = goodsComment.getPicUrls();

                map.put("addTime", goodsComment.getAddTime());
                map.put("content", goodsComment.getContent());
                map.put("picList", picUrls);
                map.put("userInfo", userInfoMap);

                dataLists.add(map);
            }
        }

        return dataLists;
    }


    @Override
    public HashMap<Object, Object> commentCount(Integer valueId, Integer type) {
        List<GoodsComment> goodsComments = goodsCommentMapper.selectAllCommentsList(valueId, type);
        int allCount = goodsComments.size();
        int hasPicCount = 0;

        for (GoodsComment goodsComment : goodsComments) {

            if (goodsComment.getPicUrls() != null || (!"[]".equals(goodsComment.getPicUrls()))) {
                hasPicCount +=1;
            }
        }

        HashMap<Object,Object> data = new HashMap<>();

        data.put("allCount",allCount);
        data.put("hasPicCount",hasPicCount);

        return data;
    }



}
