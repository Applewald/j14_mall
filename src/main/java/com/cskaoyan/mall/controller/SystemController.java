package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.MallSystem;
import com.cskaoyan.mall.service.SystemService;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hx
 * @version 1.0
 * @date 2019/7/4 9:18
 */
@RestController
public class SystemController {
    @Autowired
    SystemService systemService;


    @RequestMapping("config/mall")
    public ResponseVo<List> findMallConfig(String prefix){

        Map<String,String> systemMap = new HashMap<>();
        List<MallSystem> mall = systemService.selectMallSystemByPrefix(prefix);
        for (MallSystem mallSystem : mall) {
            systemMap.put(mallSystem.getKeyName(), mallSystem.getKeyValue());
        }
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(systemMap);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;

    }

    @RequestMapping("config/express")
    public ResponseVo<List> findFreightConfig(){
        Map<String,String> freightMap = new HashMap<>();
        List<MallSystem> mall = systemService.selectFreightConfig();
        for(MallSystem mallSystem : mall){
            freightMap.put(mallSystem.getKeyName(),mallSystem.getKeyValue());
        }
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(freightMap);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

}
