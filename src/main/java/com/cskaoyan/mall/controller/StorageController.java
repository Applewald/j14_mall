package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * author lixiaolong
 * date: 2019-07-03 19:58
 * description:
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    /*@Autowired
    StorageService storageService;
    @Autowired
    Storage storage;

    @RequestMapping("create")
    public ResponseVo storageCreate(MultipartFile file, HttpServletRequest request) throws IOException, ParseException {

        String path = request.getSession().getServletContext().getRealPath("/static/upload");
        File dic = new File(path);
        if (!dic.exists()) {
            dic.mkdirs();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = file.getOriginalFilename();
        StringBuffer sb = new StringBuffer().append(uuid).append(originalFilename.substring(originalFilename.lastIndexOf(".")));
        String key = sb.toString();
        File myfile = new File(path + "/" + key);
        file.transferTo(myfile);
        long size = file.getSize();
        storage.setSize((int) size);
        Date date = new Date();
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        storage.setKey(key);
        storage.setType(file.getContentType());
        storage.setName(originalFilename);
        storage.setUrl("http://localhost:8080/wx/storage/fetch/" + key);
        ResponseVo vo = storageService.insert(storage);
        return vo;
    }*/
}
