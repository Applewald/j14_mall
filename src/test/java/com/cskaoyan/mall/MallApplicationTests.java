package com.cskaoyan.mall;

import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.bean.wxhome.GoodsList;
import com.cskaoyan.mall.admin.mapper.CategoryMapper;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.mapper.GroupOnRulesMapper;
import com.cskaoyan.mall.admin.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "SearchHistoryMapper")
public class MallApplicationTests {

    /*@Autowired
    AddressMapper addressMapper;
    @Test
    public void contextLoads() {
        List<Address> addresses = addressMapper.queryAddressByOrder("1", "1", "add_time", "desc");
        System.out.println(addresses);

    }*/

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Test
    public void test1() {
        List<SearchHistory> searchHistories = searchHistoryMapper.querySearchHistoryByOrder("1", "吃", "add_time", "desc");
        System.out.println(searchHistories);
    }
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    GroupOnRulesMapper groupOnRulesMapper;

    @Test
    public void test2() {
        List<GoodsList> goodsLists = goodsMapper.selectAllGoodsListByCid(1036000);
        System.out.println("goodsLists = " + goodsLists);
    }
}
