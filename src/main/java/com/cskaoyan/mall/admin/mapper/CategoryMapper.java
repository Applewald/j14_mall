package com.cskaoyan.mall.admin.mapper;


import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.bean.CategoryExample;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    int update1ByPrimaryKey(Category record);

    int update2ByPrimaryKey(Category record);

    List<Category> findCategoryList();

    List<Category> findCategoryL1();

    List<Category> findL2CategorysByL1Id(@Param("L1Id") Integer id);

    List<Category> findL1CategoryList();


    Category findCategoryById(@Param("id") Integer currentId);


}