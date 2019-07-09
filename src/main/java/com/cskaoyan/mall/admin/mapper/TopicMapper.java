package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.promotion.Topic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/5 17:28
 */
@Repository
public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);
    
    List<Topic> getAllTopic(@Param("title") String title,
                            @Param("subtitle") String subtitle,
                            @Param("sort") String sort,
                            @Param("order") String order);
    
    /**以下为前台方法*/
    List<Map> getTopis();
}