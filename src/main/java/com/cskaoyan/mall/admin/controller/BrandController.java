package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.DataVo;
import com.cskaoyan.mall.admin.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("admin/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("list")
    public ResponseVo brandList(int page, int limit, Integer id, String name, String sort, String order) {
        ResponseVo<DataVo<Brand>> vo = new ResponseVo<>();
        DataVo<Brand> dataVo = brandService.findBrandList(page, limit, id, name, sort, order);
        vo.setData(dataVo);
        vo.setErrno(0);
        vo.setErrmsg("成功");
        return vo;
    }

    @RequestMapping("delete")
    public ResponseVo brandDelete(@RequestBody Brand brand) {
        System.out.println(brand);
        ResponseVo<String> vo = brandService.delete(brand.getId());
        return vo;
    }

    @RequestMapping("update")
    public ResponseVo brandUpdate(@RequestBody Brand brand) {
        System.out.println(brand);
        ResponseVo<String> vo = brandService.update(brand);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVo brandCreate(@RequestBody Brand brand) {
        System.out.println(brand);
        ResponseVo<String> vo = brandService.insert(brand);
        return vo;
    }
}
