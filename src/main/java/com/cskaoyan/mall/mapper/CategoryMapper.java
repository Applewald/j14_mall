package com.cskaoyan.mall.mapper;


import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryExample;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JsonIgnoreProperties(value={"addTime","deleted","pid","sortOrder","updateTime"}) //希望动态过滤掉的属性
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> findCategoryList();

    List<Category> findCategoryL1();

}