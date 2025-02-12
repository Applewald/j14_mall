package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.bean.FootprintExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> queryFootprintByOrder(@Param("userId")String userId,
                                 @Param("goodsId")String goodsId,
                                 @Param("sort")String sort,
                                 @Param("order")String order);

   List< Map> queryFootprints();

}